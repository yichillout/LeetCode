package com.jasper.depthfirstsearch;

public class LC0695_MaxAreaOfIsland {

    public int maxAreaOfIsland(int[][] grid) {
        int res = 0;
        int[] area = new int[1];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    area[0] = 0;
                    dfs(grid, i, j, area);
                    res = area[0] > res ? area[0] : res;
                }
            }
        }

        return res;
    }

    public void dfs(int[][] grid, int x, int y, int[] area) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] == 0) {
            return;
        }

        grid[x][y] = 0;
        area[0]++;

        dfs(grid, x + 1, y, area);
        dfs(grid, x - 1, y, area);
        dfs(grid, x, y + 1, area);
        dfs(grid, x, y - 1, area);
    }
}
