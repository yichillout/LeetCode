package com.jasper.dynamicprogramming;

public class LC1143_LongestCommonSubsequence {

    // solution 1
    public int longestCommonSubsequence1(String text1, String text2) {
        return longestCommonSubsequence(text1, text2, 0, 0);
    }

    private int longestCommonSubsequence(String text1, String text2, int i, int j) {
        if (i == text1.length() || j == text2.length()) {
            return 0;
        }

        if (text1.charAt(i) == text2.charAt(j)) {
            return 1 + longestCommonSubsequence(text1, text2, i + 1, j + 1);
        } else {
            return Math.max(longestCommonSubsequence(text1, text2, i + 1, j), longestCommonSubsequence(text1, text2, i, j + 1));
        }
    }

    // solution 2 : Bottom-up DP

    /**
     * \ _,a,b,c,d,e
     * _ 0,0,0,0,0,0
     * a 0.1,1,1,1,1
     * c 0,1,1,2,2,2
     * e 0,1,1,2,2,3
     */
    public int longestCommonSubsequence2(String text1, String text2) {
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[text1.length()][text2.length()];
    }

    // Solution 3 : Top-down DP (recursion and memoization)
    public int longestCommonSubsequence3(String text1, String text2) {
        int[][] dp = new int[text1.length()][text2.length()];
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }
        return longestCommonSubsequence3(text1, text2, 0, 0, dp);
    }

    private int longestCommonSubsequence3(String text1, String text2, int i, int j, int[][] dp) {
        if (i == text1.length() || j == text2.length()) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        if (text1.charAt(i) == text2.charAt(j)) {
            return dp[i][j] = 1 + longestCommonSubsequence3(text1, text2, i + 1, j + 1, dp);
        } else {
            return dp[i][j] = Math.max(longestCommonSubsequence3(text1, text2, i + 1, j, dp), longestCommonSubsequence3(text1, text2, i, j + 1, dp));
        }
    }
}
