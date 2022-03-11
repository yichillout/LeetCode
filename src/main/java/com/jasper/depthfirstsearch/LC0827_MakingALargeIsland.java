package com.jasper.depthfirstsearch;

import javafx.util.Pair;

import java.util.*;

public class LC0827_MakingALargeIsland {

    // solution 1 : Union Find
    static class UF {

        int[] parents;
        int[] sizes;

        public UF(int n) {
            parents = new int[n];
            sizes = new int[n];
            for (int i = 0; i < n; i++) {
                parents[i] = i;
                sizes[i] = 1;
            }
        }

        public int find(int x) {
            if (parents[x] == x) {
                return x;
            }

            parents[x] = find(parents[x]);
            return parents[x];
        }

        public void union(int x, int y) {
            int p1 = find(x);
            int p2 = find(y);

            if (p1 == p2) {
                return;
            }

            if (sizes[p1] <= sizes[p2]) {
                parents[p1] = p2;
                sizes[p2] += sizes[p1];
            } else {
                parents[p2] = p1;
                sizes[p1] += sizes[p2];
            }
        }
    }

    public static int largestIsland1(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int res = 0;

        UF uf = new UF(m * n);
        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    for (int[] dir : dirs) {
                        int x = i + dir[0];
                        int y = j + dir[1];
                        if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == 1) {
                            uf.union(i * n + j, x * n + y);
                            res = Math.max(res, uf.sizes[i * n + j]);
                        }
                    }
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    Map<Integer, Integer> map = new HashMap<>();
                    for (int[] dir : dirs) {
                        int x = i + dir[0];
                        int y = j + dir[1];
                        if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == 1) {
                            int parent = uf.find(x * n + y);
                            map.put(parent, uf.sizes[parent]);
                        }
                    }
                    res = Math.max(res, map.values().stream().mapToInt(x -> x).sum() + 1);
                }
            }
        }

        return res;
    }

    // solution 2
    public int largestIsland2(int[][] grid) {

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

    public static void main(String[] args) {
//        int[][] grid = new int[][]{{1, 1}, {1, 1}};
        int[][] grid = new int[][]{{1}};
        largestIsland1(grid);
    }
}
