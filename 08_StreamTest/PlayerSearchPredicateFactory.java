package com.fm.repository;

import com.fm.game.SearchCondition;
import com.fm.unit.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class PlayerSearchPredicateFactory {
    public static List<Predicate<Player>> makeConditions(List<SearchCondition> searchConditions){
        List<Predicate<Player>> conditions = new ArrayList<>();
        for (SearchCondition searchCond : searchConditions){
            String condition = searchCond.getCondition();
            switch (searchCond.getField()){
                case "name": conditions.add((Player p) -> p.getName().contains(condition)); break;
                case "club": conditions.add((Player p) -> p.getClub().contains(condition)); break;
                case "position": conditions.add((Player p) -> p.getPositions().contains(condition)); break;
                case "nationality": conditions.add((Player p) -> p.getNationality().contains(condition)); break;
                default: break;
            }
        }
        return conditions;
    }
}
