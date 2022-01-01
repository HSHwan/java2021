package com.fm.game;

import com.fm.repository.PlayerRepository;
import com.fm.repository.PlayerSearchPredicateFactory;
import com.fm.unit.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class StreamTest {
    public static void main(String[] args) {
        PlayerRepository.getInstance().load();

        Scanner scanner = new Scanner(System.in);
        List<SearchCondition> searchConditions = new ArrayList<>();
        boolean success = false;
        while (scanner.hasNext()) {
            String option = scanner.nextLine();
            String[] params = option.split(":");
            switch (params[0]) {
                case "club":
                case "nationality":
                case "name":
                case "position":
                    success = searchConditions.add(new SearchCondition(params[0], params[1]));
                    break;
                case "search":
                    success = searchPlayer(searchConditions);
                    break;
                case "quit":
                default:
                    success = false;
            }
            if (!success) break;
        }
        scanner.close();
    }

    private static boolean searchPlayer(List<SearchCondition> searchConditions) {
        List<Predicate<Player>> conditions = PlayerSearchPredicateFactory.makeConditions(searchConditions);
        List<Player> result = PlayerRepository.getInstance().query(conditions);
        System.out.printf("%d - %s\n", result.size(), result);
        searchConditions.clear();
        return true;
    }
}