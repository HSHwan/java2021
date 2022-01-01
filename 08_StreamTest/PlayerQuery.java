package com.fm.repository;

import com.fm.unit.Player;

import java.util.List;
import java.util.function.Predicate;

import static java.util.stream.Collectors.toList;

public class PlayerQuery {
    public static List<Player> query(List<Player> players, List<Predicate<Player>> conditions){
        List<Player> queryPlayers = players.stream()
                .filter((Player p) -> conditions.stream().reduce(c->true, Predicate::and).test(p))
                .collect(toList());
        return queryPlayers;
    }
}
