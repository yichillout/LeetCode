package com.jasper.dynamicprogramming;

import java.util.Arrays;

public class LC1691_MaximumHeightByStackingCuboids {

    public int maxHeight(int[][] cuboids) {

        for (int[] cuboid : cuboids) {
            Arrays.sort(cuboid);
        }

        Arrays.sort(cuboids, (int[] a, int[] b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            } else if (a[1] != b[1]) {
                return a[1] - b[1];
            } else {
                return a[2] - b[2];
            }
        });

        int[] dp = new int[cuboids.length];

        for (int i = 0; i < cuboids.length; i++) {
            dp[i] = cuboids[i][2];
            for (int j = 0; j < i; j++) {
                if (cuboids[j][0] <= cuboids[i][0] && cuboids[j][1] <= cuboids[i][1] && cuboids[j][2] <= cuboids[i][2]) {
                    dp[i] = Math.max(dp[i], dp[j] + cuboids[i][2]);
                }
            }
        }

        int res = 0;
        for (int i = 0; i < dp.length; i++) {
            if (dp[i] > res) {
                res = dp[i];
            }
        }
        return res;
    }
}
