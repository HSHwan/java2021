package com.fm.client;
import com.fm.unit.Player;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.List;
import java.util.Scanner;

import static java.util.stream.Collectors.toList;

public class PlayerClient {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String baseURL = "http://localhost:9000/players?";
        String query = "", queryIn;
        String []querySplit;
        ObjectMapper mapper = new ObjectMapper();
        List<Player> players;
        CollectionType playerListType =
                mapper.getTypeFactory().constructCollectionType(List.class, Player.class);

        queryIn = scanner.nextLine();
        querySplit = queryIn.split(" ");
        for(int i = 0; i < querySplit.length-1; i+=2){
            if(query.equals("")){
                query += querySplit[i] + "=" + querySplit[i+1];
            }
            else {
                query += "&" + querySplit[i] + "=" + querySplit[i+1];
            }
        }
        System.out.println(baseURL + query);

        HttpClient client = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_1_1)
                .followRedirects(HttpClient.Redirect.NORMAL)
                .build();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(baseURL + query))
                .timeout(Duration.ofMinutes(1))
                .header("Content-Type", "application/json")
                .GET()
                .build();
        try {
            HttpResponse<String> response =
                    client.send(request, HttpResponse.BodyHandlers.ofString());
            if(response.statusCode() == 200){
                players = mapper.readValue(response.body(), playerListType);
                System.out.println(players.stream().map(Player::getId).collect(toList()));
            }
        } catch (IOException ex){
            System.err.println(ex);
        } catch (InterruptedException ex) {
            System.err.println(ex);
        }
    }
}
