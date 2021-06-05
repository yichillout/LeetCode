package com.jasper.array;

import java.util.TreeMap;

public class LC846_HandOfStraights {

    public boolean isNStraightHand(int[] hand, int W) {

        if (hand.length % W != 0) {
            return false;
        }

        TreeMap<Integer, Integer> tm = new TreeMap<>();

        for (int i = 0; i < hand.length; i++) {
            if (!tm.containsKey(hand[i])) {
                tm.put(hand[i], 1);
            } else {
                tm.put(hand[i], tm.get(hand[i]) + 1);
            }
        }

        while (tm.size() > 0) {

            int min = tm.firstKey();

            for (int card = min; card < min + W; card++) {

                if (!tm.containsKey(card)) {
                    return false;
                }

                tm.put(card, tm.get(card) - 1);

                if (tm.get(card) == 0) {
                    tm.remove(card);
                }
            }
        }

        return true;
    }
}
