package com.jasper.dynamicprogramming;

public class LC0091_DecodeWays {

    public int numDecodings(String s) {
        char[] ss = s.toCharArray();

        int[] dp = new int[ss.length + 1];
        dp[0] = 1;

        int num = 0;
        for (int i = 1; i < dp.length; i++) {
            dp[i] = 0;

            // last 1 digit
            num = ss[i - 1] - '0';
            if (num >= 1 && num <= 9) {
                dp[i] += dp[i - 1];
            }

            // last 2 digit
            if (i > 1) {
                num = (ss[i - 2] - '0') * 10 + ss[i - 1] - '0';
                if (num >= 10 && num <= 26) {
                    dp[i] += dp[i - 2];
                }
            }
        }

        return dp[dp.length - 1];
    }
}
