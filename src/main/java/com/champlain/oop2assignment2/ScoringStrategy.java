package com.champlain.oop2assignment2;

import java.util.List;

public interface ScoringStrategy {
    static int calculateScore(List<Card> cards) {

        return cards.size();
    }
}

