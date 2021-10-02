package com.jasper.depthfirstsearch;

import javafx.util.Pair;

import java.util.*;

public class LC0827_MakingALargeIsland {

    public int largestIsland(int[][] grid) {

        int N = grid.length;
        Map<Integer, Integer> countMap = new HashMap<>();
        int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int index = 3;

        int max = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] == 1) {
                    int area = helper(grid, i, j, index);
                    countMap.put(index, area);
                    max = area > max ? area : max;
                    index++;
                }
            }
        }


        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] == 0) {
                    int combinedArea = 1;
                    Set<Integer> visited = new HashSet<>();

                    for (int k = 0; k < dirs.length; k++) {
                        int xx = i + dirs[k][0];
                        int yy = j + dirs[k][1];
                        if (xx >= 0 && xx < N && yy >= 0 && yy < N && !visited.contains(grid[xx][yy])
                                && countMap.containsKey(grid[xx][yy])) {
                            combinedArea += countMap.get(grid[xx][yy]);
                            visited.add(grid[xx][yy]);
                        }
                    }

                    max = combinedArea > max ? combinedArea : max;
                }
            }
        }

        return max;
    }

    public int helper(int[][] grid, int x, int y, int index) {
        int N = grid.length;

        int area = 1;
        grid[x][y] = index;
        int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        for (int i = 0; i < dirs.length; i++) {
            int xx = x + dirs[i][0];
            int yy = y + dirs[i][1];

            if (xx >= 0 && xx < N && yy >= 0 && yy < N && grid[xx][yy] == 1) {
                area += helper(grid, xx, yy, index);
            }
        }

        return area;
    }
}
