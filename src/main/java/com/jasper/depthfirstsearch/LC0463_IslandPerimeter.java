package com.jasper.depthfirstsearch;

public class LC0463_IslandPerimeter {

    // solution 1 : DFS
    public int islandPerimeter1(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    return dfs(grid, i, j);
                }
            }
        }

        return 0;
    }

    public int dfs(int[][] grid, int x, int y) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] == 0) {
            return 1;
        }

        if (grid[x][y] == -1) {
            return 0;
        }

        grid[x][y] = -1;

        return dfs(grid, x + 1, y) + dfs(grid, x, y + 1) + dfs(grid, x - 1, y) + dfs(grid, x, y - 1);
    }


    // solution 2
    public int islandPerimeter2(int[][] grid) {

        int count = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    count += 4;
                    if (i > 0 && grid[i - 1][j] == 1) {
                        count -= 2;
                    }
                    if (j > 0 && grid[i][j - 1] == 1) {
                        count -= 2;
                    }
                }
            }
        }

        return count;
    }
}
