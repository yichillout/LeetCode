package com.jasper.breadthfirstsearch;

import java.util.*;

public class LC0130_SurroundedRegions {

    public void solve(char[][] board) {
        int N = board.length;
        int M = board[0].length;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if ((i == 0 || j == 0 || i == N - 1 || j == M - 1) && board[i][j] == 'O') {
                    helper(board, i, j);
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }

                if (board[i][j] == '#') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    public void helper(char[][] board, int x, int y) {
        int N = board.length;
        int M = board[0].length;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        board[x][y] = '#';

        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();

                for (int j = 0; j < dirs.length; j++) {
                    int xx = cur[0] + dirs[j][0];
                    int yy = cur[1] + dirs[j][1];

                    if (xx >= 0 && xx < N && yy >= 0 && yy < M && board[xx][yy] == 'O') {
                        queue.offer(new int[]{xx, yy});
                        board[xx][yy] = '#';
                    }
                }
            }
        }
    }
}
