package com.jasper.dynamicprogramming;

public class LC0132_PalindromePartitioningII {

    public int minCut(String s) {
        char[] ss = s.toCharArray();
        int n = ss.length;
        if (n == 0) {
            return 0;
        }

        boolean[][] isPalin = calcPalin(ss, n);

        int[] f = new int[n + 1];
        int[] pi = new int[n + 1];
        f[0] = 0;
        int i, j;
        for (i = 1; i <= n; i++) {
            f[i] = Integer.MAX_VALUE;
            for (j = 0; j < i; j++) {
                if (isPalin[j][i - 1]) {
                    f[i] = Math.min(f[i], f[j] + 1);
                    if (f[i] == f[j] + 1) {
                        pi[i] = j;
                    }
                }
            }
        }

        i = n;
        while (i > 0) {
            // ss[pi[i]]... ss[i-1] is the last segment
            for (j = pi[i]; j < i; j++) {
                System.out.print(ss[j]);
            }

            System.out.println("");
            i = pi[i];
        }

        return f[n] - 1;
    }

    public boolean[][] calcPalin(char[] ss, int n) {
        int i, j, mid;
        boolean[][] isPalin = new boolean[n][n];
        for (i = 0; i < n; i++) {
            for (j = i; j < n; j++) {
                isPalin[i][j] = false;
            }
        }

        for (mid = 0; mid < n; mid++) {
            // ss[mid] is the axis
            i = j = mid;
            while (i >= 0 && j < n && ss[i] == ss[j]) {
                isPalin[i][j] = true;
                i--;
                j++;
            }

            // ss[mid]|ss[mid+1]
            i = mid;
            j = mid + 1;
            while (i >= 0 && j < n && ss[i] == ss[j]) {
                isPalin[i][j] = true;
                i--;
                j++;
            }
        }

        return isPalin;
    }
}
