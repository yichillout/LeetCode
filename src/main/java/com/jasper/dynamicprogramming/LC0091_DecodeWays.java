package com.jasper.dynamicprogramming;

public class LC0091_DecodeWays {

    /**
     * solution 1 : DP
     * dp:    1 1 2 2
     * index: 0 1 2 3
     *          2 6 6
     *          B F F
     *            Z F
     */
    public int numDecodings1(String s) {
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


    public int numDecodings2(String s) {
        return s.length() == 0 ? 0 : numDecodings(0, s);
    }

    private int numDecodings(int p, String s) {
        int n = s.length();

        if (p == n) {
            return 1;
        }

        if (s.charAt(p) == '0') {
            return 0;
        }

        int res = numDecodings(p + 1, s);

        if (p + 1 < n && (s.charAt(p) == '1' || s.charAt(p) == '2' && s.charAt(p + 1) < '7')) {
            res += numDecodings(p + 2, s);
        }

        return res;
    }
}
