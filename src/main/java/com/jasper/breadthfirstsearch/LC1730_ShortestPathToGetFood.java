package com.jasper.breadthfirstsearch;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class LC1730_ShortestPathToGetFood {

    public int getFood(char[][] grid) {
        int N = grid.length;
        int M = grid[0].length;
        int result = 0;

        int[][] dir = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        Queue<int[]> queue = new LinkedList<>();
        boolean[][] used = new boolean[N][M];

        int[] start = new int[2];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '*') {
                    start[0] = i;
                    start[1] = j;
                    break;
                }
            }
        }

        queue.add(start);
        used[start[0]][start[1]] = true;

        while (queue.size() != 0) {

            int size = queue.size();
            result++;

            for (int i = 0; i < size; i++) {
                int[] point = queue.poll();

                for (int j = 0; j < 4; j++) {
                    int x = point[0] + dir[j][0];
                    int y = point[1] + dir[j][1];

                    if (x >= 0 && x < N && y >= 0 && y < M && !used[x][y]) {
                        if (grid[x][y] == '#') {
                            return result;
                        }

                        if (grid[x][y] == 'O') {
                            queue.offer(new int[]{x, y});
                        }

                        used[x][y] = true;
                    }

                }

            }

        }

        return -1;
    }
}
