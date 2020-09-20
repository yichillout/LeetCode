package com.jasper.dynamicprogramming;

public class LC0188_BestTimeToBuyAndSellStockIV {

    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if (n == 0) {
            return 0;
        }

        int res = 0;
        int i, j, t;
        if (k > n / 2) {
            for (i = 0; i < prices.length - 1; i++) {
                if (prices[i + 1] > prices[i]) {
                    res += prices[i + 1] - prices[i];
                }
            }
            return res;
        }


        int[][] f = new int[n + 1][2 * k + 1 + 1];


        for (t = 1; t <= 2 * k + 1; t++) {
            f[0][t] = Integer.MIN_VALUE; //impossible
        }

        f[0][1] = 0;
        for (i = 1; i <= n; i++) {
            // phase 1,3,...,2*k + 1 ==> f[i][j] = max {f[i - 1][j], f[i - 1][j - 1] + Pi-1 - Pi -2}
            for (j = 1; j <= 2 * k + 1; j += 2) {
                f[i][j] = f[i - 1][j];
                if (j > 1 && i > 1 && f[i - 1][j - 1] != Integer.MIN_VALUE) {
                    f[i][j] = Math.max(f[i][j], f[i - 1][j - 1] + prices[i - 1] - prices[i - 2]);
                }
            }

            // phase 2,4,...2*k ==> f[i][j] = max {f[i - 1][j] + Pi-1 - Pi -2, f[i - 1][j - 1]}
            for (j = 2; j <= 2 * k + 1; j += 2) {
                f[i][j] = f[i - 1][j - 1];
                if (i > 1 && f[i - 1][j] != Integer.MIN_VALUE) {
                    f[i][j] = Math.max(f[i][j], f[i - 1][j] + prices[i - 1] - prices[i - 2]);
                }
            }
        }

        for (j = 1; j <= 2 * k + 1; j += 2) {
            res = Math.max(res, f[n][j]);
        }
        return res;
    }
}
