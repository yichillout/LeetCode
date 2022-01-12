package com.jasper.depthfirstsearch;

import java.util.*;

public class LC0200_NumberOfIslands {

    // Solution 1 : DFS
    public int numIslands(char[][] grid) {
        int res = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    res++;
                }
            }
        }

        return res;
    }

    public void dfs(char[][] grid, int x, int y) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] == '0') {
            return;
        }

        grid[x][y] = '0';

        dfs(grid, x + 1, y);
        dfs(grid, x - 1, y);
        dfs(grid, x, y + 1);
        dfs(grid, x, y - 1);
    }

    // Solution 2 : BFS
    public int numIslands2(char[][] grid) {

        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;

        Queue<int[]> queue = new LinkedList<>();
        int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int islandNum = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {

                if (grid[i][j] == '1') {
                    int[] position = {i, j};
                    grid[i][j] = '0';
                    islandNum++;
                    queue.offer(position);
                    while (!queue.isEmpty()) {
                        int[] temp = queue.poll();
                        for (int k = 0; k < 4; k++) {
                            int x = temp[0] + dir[k][0];
                            int y = temp[1] + dir[k][1];
                            if (x < grid.length && x >= 0 && y < grid[0].length
                                    && y >= 0 && grid[x][y] == '1') {
                                int[] curPosition = {x, y};
                                queue.offer(curPosition);
                                grid[x][y] = '0';
                            }
                        }
                    }
                }

            }
        }

        return islandNum;

    }

}
