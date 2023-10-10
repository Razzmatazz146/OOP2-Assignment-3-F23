package com.champlain.oop2assignment2;

import java.util.List;

public class SimpleCountScoringStrategy implements ScoringStrategy {
    public static int calculateScore(List<Card> cards) {
        return cards.size();
    }
}
