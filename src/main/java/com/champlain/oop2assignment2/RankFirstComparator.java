package com.champlain.oop2assignment2;

import java.util.Comparator;

public class RankFirstComparator implements Comparator<Card>{
    @Override
    public int compare(Card card1, Card card2) {
        // Compare cards based on rank first, then suit if ranks are equal
        int rankComparison = card1.getRank().compareTo(card2.getRank());
        if (rankComparison != 0) {
            return rankComparison;
        } else {
            // If ranks are equal, compare based on suit
            return card1.getSuit().compareTo(card2.getSuit());
        }
    }
}
