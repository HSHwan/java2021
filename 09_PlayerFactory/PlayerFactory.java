package com.fm.repository;

import com.fm.unit.Player;

import java.util.ArrayList;
import java.util.List;

public class PlayerFactory {
    public static Player createPlayersWithoutID(String[] fields){
        int height = Integer.parseInt(fields[Player.HEIGHT-1]),
                overall = Integer.parseInt(fields[Player.OVERALL-1]);
        String name = fields[Player.NAME-1], nationality = fields[Player.NATIONALITY-1],
                club = fields[Player.CLUB-1];
        List<String> positions = new ArrayList<>();
        if (fields[Player.POSITION-1].startsWith("\"")) {
            for (int i = Player.POSITION-1; i < fields.length; i++)
                positions.add(fields[i].replace("\"", "").trim());
        } else {
            positions.add(fields[Player.POSITION-1]);
        }
        Player player = new Player(name, height, nationality, club, overall, positions);
        return player;
    }

    public static Player createPlayers(String[] fields){
        Player player = new Player(getId(fields), getName(fields), getHeight(fields),
                getNationality(fields), getClub(fields), getOverall(fields), getPosition(fields));
        return player;
    }

    private static List<String> getPosition(String[] fields) {
        List<String> positions = new ArrayList<>();
        if (fields[Player.POSITION].startsWith("\"")) {
            for (int i = Player.POSITION; i < fields.length; i++)
                positions.add(fields[i].replace("\"", "").trim());
        } else {
            positions.add(fields[Player.POSITION]);
        }
        return positions;
    }

    private static int getOverall(String[] arr) {
        return Integer.parseInt(arr[Player.OVERALL]);
    }

    private static String getClub(String[] fields) {
        return fields[Player.CLUB];
    }

    private static String getNationality(String[] fields) {
        return fields[Player.NATIONALITY];
    }

    private static int getHeight(String[] fields) {
        return Integer.parseInt(fields[Player.HEIGHT]);
    }

    private static String getName(String[] fields) {
        return fields[Player.NAME];
    }

    private static int getId(String[] fields) {
        return Integer.parseInt(fields[Player.ID]);
    }
}
