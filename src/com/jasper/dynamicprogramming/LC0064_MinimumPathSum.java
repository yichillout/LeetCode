package com.jasper.dynamicprogramming;

// print the path
public class LC0064_MinimumPathSum {

    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] f = new int[n][m];
        int[][] pi = new int[n][m]; // pi[i][j] = 1 : from (i - 1, j);  pi[i][j] = 2 : from (i, j - 1);


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 && j == 0) {
                    f[i][j] = grid[i][j];
                    continue;
                }

                f[i][j] = Integer.MAX_VALUE;
                if (i > 0) {
                    f[i][j] = Math.min(f[i][j], f[i - 1][j]);
                    if (f[i][j] == f[i - 1][j]) {
                        pi[i][j] = 1; // from up
                    }
                }
                if (j > 0) {
                    f[i][j] = Math.min(f[i][j], f[i][j - 1]);
                    if (f[i][j] == f[i][j - 1]) {
                        pi[i][j] = 2; // from left
                    }
                }

                f[i][j] += grid[i][j];
            }
        }

        int[] path = new int[m + n - 1];
        int x = n - 1;
        int y = m - 1;
        for (int i = m + n - 2; i >= 0; i--) {
            path[i] = grid[x][y];
            if (i > 0) {
                if (pi[x][y] == 1) {
                    x--;
                } else {
                    y--;
                }
            }
        }

        for (int i = 0; i < path.length; i++) {
            System.out.println(path[i]);
        }

        return f[n - 1][m - 1];
    }
}
