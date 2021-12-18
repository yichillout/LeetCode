package com.jasper.dynamicprogramming;

public class LC0361_BombEnemy {

    public static int maxKilledEnemies(char[][] grid) {
        int m = grid.length;
        int n = m > 0 ? grid[0].length : 0;

        int result = 0;
        int rows = 0;
        int[] cols = new int[n];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {

                if (j == 0 || grid[i][j - 1] == 'W') {
                    rows = 0;
                    for (int k = j; k < n && grid[i][k] != 'W'; ++k) {
                        if (grid[i][k] == 'E') {
                            rows += 1;
                        }
                    }
                }

                if (i == 0 || grid[i - 1][j] == 'W') {
                    cols[j] = 0;
                    for (int k = i; k < m && grid[k][j] != 'W'; ++k) {
                        if (grid[k][j] == 'E') {
                            cols[j] += 1;
                        }
                    }
                }

                if (grid[i][j] == '0' && rows + cols[j] > result)
                    result = rows + cols[j];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        char[][] grid = {{'0', 'E', '0', '0'}, {'E', '0', 'W', 'E'}, {'0', 'E', '0', '0'}};
        System.out.println(maxKilledEnemies(grid));

    }
}
