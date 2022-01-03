package com.company.microsoft;

import java.util.Arrays;

public class MinStepsToMakePilesEqualHeight {

    public int minSteps(int[] piles) {
        int len = piles.length;

        if (len <= 1) {
            return 0;
        }

        Arrays.sort(piles);

        int res = 0;
        int distinctNums = 0;

        for (int i = 1; i < len; ++i) {
            if (piles[i] != piles[i - 1]) {
                distinctNums++;
            }

            res += distinctNums;
        }
        return res;
    }
}
