package com.jasper.breadthfirstsearch;

import java.util.LinkedList;
import java.util.Queue;

public class LC1091_ShortestPathInBinaryMatrix {

    public int shortestPathBinaryMatrix(int[][] grid) {

        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return -1;
        }

        int N = grid.length;
        int M = grid[0].length;
        boolean[][] visited = new boolean[N][M];
        int[][] dir = {{1, 0}, {-1, 0}, {1, 1}, {-1, 1}, {1, -1}, {-1, -1}, {0, 1}, {0, -1}};
        int result = 0;

        if (grid[0][0] == 1 || grid[N - 1][M - 1] == 1) {
            return -1;
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        visited[0][0] = true;

        while (!queue.isEmpty()) {

            int size = queue.size();
            result++;

            for (int i = 0; i < size; i++) {

                int[] p = queue.poll();

                if (p[0] == N - 1 && p[1] == M - 1) {
                    return result;
                }

                for (int j = 0; j < dir.length; j++) {
                    int x = p[0] + dir[j][0];
                    int y = p[1] + dir[j][1];

                    if (isValidRange(x, y, N, M) && grid[x][y] == 0 && !visited[x][y]) {
                        queue.offer(new int[]{x, y});
                        visited[x][y] = true;
                    }
                }
            }

        }


        return -1;
    }

    public boolean isValidRange(int x, int y, int N, int M) {
        return x >= 0 && x < N && y >= 0 && y < M;
    }
}
