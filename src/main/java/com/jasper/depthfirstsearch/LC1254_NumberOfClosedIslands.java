package com.jasper.depthfirstsearch;

public class LC1254_NumberOfClosedIslands {

    public int closedIsland(int[][] grid) {
        int res = 0;
        int m = grid.length;
        int n = grid[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0 && dfs(grid, i, j, m, n)) {
                    res++;
                }
            }
        }

        return res;
    }

    public boolean dfs(int[][] grid, int x, int y, int m, int n) {
        if (x < 0 || x >= m || y < 0 || y >= n) { // 如果到边界，证明不可能被包围，返回false
            return false;
        }

        if (grid[x][y] == 1) {
            return true;
        }

        grid[x][y] = 1;
        return dfs(grid, x + 1, y, m, n)
                && dfs(grid, x - 1, y, m, n)
                && dfs(grid, x, y + 1, m, n)
                && dfs(grid, x, y - 1, m, n);
    }
}
