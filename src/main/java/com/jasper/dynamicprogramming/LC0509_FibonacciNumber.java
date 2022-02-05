package com.jasper.dynamicprogramming;

public class LC0509_FibonacciNumber {

    // solution 1 : DP iterative
    public int fib1(int n) {
        if (n < 2) {
            return n;
        }

        int[] dp = new int[n + 1];

        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

    // solution 2 : DP iterative with space enhancement
    public int fib2(int n) {
        if (n < 2) {
            return n;
        }

        int prev1 = 0;
        int prev2 = 1;

        int res = 0;

        for (int i = 2; i <= n; i++) {
            res = prev1 + prev2;
            prev1 = prev2;
            prev2 = res;
        }

        return res;
    }

    // solution 3 : DSF : recursive
    public int fib3(int n) {
        return dfs(n, new int[n + 1]);
    }

    public int dfs(int n, int[] memo) {
        if (n < 2) {
            return n;
        }

        if (memo[n] > 0) {
            return memo[n];
        }

        memo[n] = dfs(n - 1, memo) + dfs(n - 2, memo);
        return memo[n];
    }

    // solution 4 : DFS : recursive without memorize (Time Limit Exceeded)
    public int fib4(int n) {
        return dfs1(n);
    }

    public int dfs1(int n) {
        if (n < 2) {
            return n;
        }

        return dfs1(n - 1) + dfs1(n - 2);
    }
}
