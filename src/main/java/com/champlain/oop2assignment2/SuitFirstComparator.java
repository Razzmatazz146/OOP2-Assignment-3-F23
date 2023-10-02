package com.champlain.oop2assignment2;

import java.util.Comparator;

public class SuitFirstComparator implements Comparator<Card>{
    @Override
    public int compare(Card card1, Card card2) {
        // Compare cards based on suit first, then rank if suits are equal
        int suitComparison = card1.getSuit().compareTo(card2.getSuit());
        if (suitComparison != 0) {
            return suitComparison;
        } else {
            // If suits are equal, compare based on rank
            return card1.getRank().compareTo(card2.getRank());
        }
    }
}
