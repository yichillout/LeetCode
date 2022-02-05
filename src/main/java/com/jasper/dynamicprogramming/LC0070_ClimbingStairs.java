package com.jasper.dynamicprogramming;

// similar : 509. Fibonacci Number
public class LC0070_ClimbingStairs {

    // solution 1 : DP : iterative
    public int climbStairs1(int n) {
        if (n <= 2) {
            return n;
        }

        int[] dp = new int[n + 1];

        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

    // solution 2 : DP : iterative with space enhancement
    public int climbStairs2(int n) {
        if (n <= 2) {
            return n;
        }

        int prev1 = 1;
        int prev2 = 2;

        int res = 0;

        for (int i = 3; i <= n; i++) {
            res = prev1 + prev2;
            prev1 = prev2;
            prev2 = res;
        }

        return res;
    }

    // solution 3 : DSF : recursive
    public int climbStairs3(int n) {
        return helper(n, new int[n + 1]);
    }

    public int helper(int n, int[] memo) {
        if (n <= 2) {
            return n;
        }

        if (memo[n] > 0) {
            return memo[n];
        }

        memo[n] = helper(n - 1, memo) + helper(n - 2, memo);
        return memo[n];
    }

    // solution 4 : DFS : recursive without memorize (Time Limit Exceeded)
    public int climbStairs4(int n) {
        return helper1(n, new int[n + 1]);
    }

    public int helper1(int n, int[] memo) {
        if (n <= 2) {
            return n;
        }

        return helper1(n - 1, memo) + helper(n - 2, memo);
    }
}
