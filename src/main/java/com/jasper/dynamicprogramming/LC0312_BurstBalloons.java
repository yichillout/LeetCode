package com.jasper.dynamicprogramming;

public class LC0312_BurstBalloons {

    public int maxCoins(int[] orgNums) {
        if (orgNums == null || orgNums.length == 0) {
            return 0;
        }

        int len = orgNums.length + 2;
        int[] nums = new int[len];
        nums[0] = nums[len - 1] = 1;

        for (int i = 0; i < orgNums.length; i++) {
            nums[i + 1] = orgNums[i];
        }

        int[][] dp = new int[len][len];
        for (int i = 1; i < len; i++) {
            for (int lo = 0; lo < len - i; lo++) {
                int hi = lo + i;
                for (int k = lo + 1; k < hi; k++) {
                    dp[lo][hi] = Math.max(dp[lo][hi], nums[lo] * nums[k]
                            * nums[hi] + dp[lo][k] + dp[k][hi]);
                }
            }
        }

        return dp[0][len - 1];
    }
}
