package com.fm.repository;

import com.fm.unit.Player;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.function.Predicate;

public class FileRepository implements IRepository {
    public static final String[] FILE_HEADER =
            {"sofifa_id", "short_name", "height_cm", "nationality", "club", "overall", "player_positions", "\n"};
    private static FileRepository instance = new FileRepository();
    public final String FILENAME =
            Thread.currentThread().getContextClassLoader().getResource("players_20_short.csv").getFile();
    private boolean loaded = false;
    private List<Player> players;

    private FileRepository() {
        load();
    }

    public static FileRepository getInstance() {
        return instance;
    }

    private Player create(String[] fields) {
        return PlayerFactory.createPlayers(fields);
    }

    public void load() {
        if (!loaded) {
            players = new ArrayList<>();
            BufferedReader inputStream = null;
            Path src = Paths.get(FILENAME);
            Charset charset = Charset.forName("UTF-8");
            try {
                inputStream = Files.newBufferedReader(src, charset);

                String line;
                while ((line = inputStream.readLine()) != null) {
                    String[] player_info = line.split(",");
                    if (player_info[0].equals(FILE_HEADER[0]))
                        continue;
                    Player player = create(player_info);
                    players.add(player);
                }
            } catch (IOException e) {
                return;
            } finally {
                try {
                    inputStream.close();
                }
                catch(IOException e){
                    return ;
                }
            }
        }
    }

    @Override
    public int count() {
        return players.size();
    }

    @Override
    public void save(Player t) {
        BufferedWriter outputStream = null;
        try {
            outputStream = new BufferedWriter(new FileWriter(FILENAME, true));

            outputStream.append(t.toString());
            outputStream.newLine();
        }
        catch (IOException e){
            return ;
        }
        finally {
            try {
                outputStream.close();
            }
            catch(IOException e){
                return ;
            }
        }
        players.add(t);
    }

    @Override
    public void delete(Player t) {
        players.removeIf(p -> p.equals(t));
        Path src = Paths.get(FILENAME);
        Charset charset = Charset.forName("UTF-8");
        try(BufferedWriter bw = Files.newBufferedWriter(src, charset);){
            for (Player player : players){
                bw.write(player.toString(),0,player.toString().length());
                bw.newLine();
            }
        }
        catch (IOException e){
            return;
        }
    }

    @Override
    public void deleteById(int id) {
        //Path src = Paths.get("C:/Users/수현/IdeaProjects/Java_Platform/src/players_20_short.csv");
        Path src = Paths.get(FILENAME);
        Charset charset = Charset.forName("UTF-8");
        try(BufferedReader br = Files.newBufferedReader(src, charset);
            BufferedWriter bw = Files.newBufferedWriter(src, charset);){
            String line;
            while((line = br.readLine())!=null){
                String[] player_info = line.split(",");
                if (Integer.parseInt(player_info[0]) != id){
                    bw.write(line, 0, line.length());
                    bw.newLine();
                }
            }
        }
        catch (IOException e){
            return;
        }
        players.removeIf(p -> p.getId() == id);
    }

    @Override
    public boolean existsById(int id) {
        for (Player player : players){
            if (player.getId() == id)
                return true;
        }
        return false;
    }

    @Override
    public Iterable<Player> findAll() {
        return null;
    }

    @Override
    public Optional<Player> findById(int id) {
        Optional<Player> player = players.stream()
                .filter(p -> p.getId() == id)
                .findAny();
        return player;
    }

    @Override
    public List<Player> findByConditions(List<Predicate<Player>> conditions) {
        if (0 < conditions.size() && 0 < players.size())
            return PlayerQuery.query(players, conditions);
        else
            return new ArrayList<>();
    }
}
