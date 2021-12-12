package com.jasper.dynamicprogramming;

public class LC0322_CoinChange {

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        dp[0] = 0;

        for (int i = 1; i < dp.length; i++) {
            dp[i] = Integer.MAX_VALUE;

            for (int j = 0; j < coins.length; j++) {
                if (i == coins[j]) {
                    dp[i] = 1;
                }

                if (i - coins[j] >= 0 && dp[i - coins[j]] > 0) {
                    dp[i] = Math.min(dp[i - coins[j]] + 1, dp[i]);
                }
            }

            if (dp[i] == Integer.MAX_VALUE) {
                dp[i] = -1;
            }
        }

        return dp[amount];
    }
}
