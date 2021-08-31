package com.jasper.breadthfirstsearch;

import java.util.*;


public class LC0490_TheMaze {

    public boolean hasPath(int[][] maze, int[] start, int[] destination) {

        int N = maze.length;
        int M = maze[0].length;

        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[N][M];

        int[][] dir = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        queue.offer(start);
        visited[start[0]][start[1]] = true;

        while (!queue.isEmpty()) {

            int size = queue.size();

            for (int i = 0; i < size; i++) {

                int[] cur = queue.poll();

                if (cur[0] == destination[0] && cur[1] == destination[1]) {
                    return true;
                }

                for (int j = 0; j < dir.length; j++) {
                    int[] next = getPosition(cur, dir[j], maze);

                    if (!visited[next[0]][next[1]]) {
                        queue.offer(next);
                        visited[next[0]][next[1]] = true;
                    }
                }
            }
        }

        return false;
    }

    public int[] getPosition(int[] cur, int[] dir, int[][] maze) {
        int N = maze.length;
        int M = maze[0].length;

        int x = cur[0];
        int y = cur[1];

        while (x + dir[0] >= 0 && x + dir[0] < N && y + dir[1] >= 0 && y + dir[1] < M
                && maze[x + dir[0]][y + dir[1]] == 0) {
            x += dir[0];
            y += dir[1];
        }

        return new int[]{x, y};
    }

}
