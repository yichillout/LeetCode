package com.jasper.dynamicprogramming;

public class LC0279_PerfectSquares {



    public int numSquares(int n) {
        if (n == 0) {
            return 0;
        }

        int[] f = new int[n + 1];

        f[0] = 0;

        for (int i = 1; i <= n; i++) {
            f[i] = Integer.MAX_VALUE;
            for (int j = 1; j <= i; j++) { // j is from 1 to i
                if (i - j * j >= 0) {
                    f[i] = Math.min(f[i], f[i - j * j] + 1);
                }
            }
        }

        return f[n];
    }
}
