package com.jasper.dynamicprogramming;

public class LC0256_PaintHouse {

    public int minCost(int[][] costs) {

        int n = costs.length;

        if (n == 0)
            return 0;

        int[][] dp = new int[n + 1][3];

        dp[0][0] = 0;
        dp[0][1] = 0;
        dp[0][2] = 0;

        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < 3; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = 0; k < 3; k++) {
                    if (k == j) {
                        continue;
                    }

                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][k] + costs[i - 1][k]);
                }
            }
        }

        return Math.min(dp[n][0], Math.min(dp[n][1], dp[n][2]));
    }
}
