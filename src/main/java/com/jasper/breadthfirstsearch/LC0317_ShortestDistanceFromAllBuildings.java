package com.jasper.breadthfirstsearch;

import java.util.LinkedList;
import java.util.Queue;

public class LC0317_ShortestDistanceFromAllBuildings {

    public int shortestDistance(int[][] grid) {

        int N = grid.length;
        int M = grid[0].length;

        int[][] distance = new int[N][M];
        int[][] visitedCount = new int[N][M];
        int buildingCount = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (grid[i][j] == 1) {
                    buildingCount++;
                    bfs(i, j, distance, visitedCount, grid);
                }
            }
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (grid[i][j] == 0 && visitedCount[i][j] == buildingCount) {
                    min = Math.min(min, distance[i][j]);
                }
            }
        }

        return min == Integer.MAX_VALUE ? -1 : min;
    }

    public void bfs(int x, int y, int[][] distance, int[][] visitedCount, int[][] grid) {

        int N = grid.length;
        int M = grid[0].length;

        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[N][M];
        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int d = 0;

        q.offer(new int[]{x, y});
        visited[x][y] = true;

        while (!q.isEmpty()) {
            int size = q.size();
            d++;

            for (int i = 0; i < size; i++) {

                int[] cur = q.poll();

                for (int j = 0; j < dirs.length; j++) {
                    int xx = cur[0] + dirs[j][0];
                    int yy = cur[1] + dirs[j][1];

                    if (isInRange(xx, yy, N, M) && grid[xx][yy] == 0 && !visited[xx][yy]) {
                        distance[xx][yy] += d;
                        visitedCount[xx][yy]++;
                        q.offer(new int[]{xx, yy});
                        visited[xx][yy] = true;
                    }
                }
            }
        }
    }


    public boolean isInRange(int x, int y, int n, int m) {
        return x >= 0 && x < n && y >= 0 && y < m;
    }
}
