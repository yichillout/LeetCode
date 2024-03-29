package com.jasper.breadthfirstsearch;

import java.util.LinkedList;
import java.util.Queue;

public class LC0529_Minesweeper {

    /**
     * @param board
     * @param click
     * @return
     * 1. If click on a mine ('M'), mark it as 'X', stop further search.
     * 2. If click on an empty cell ('E'), depends on how many surrounding mine:
     *  2.1 Has surrounding mine(s), mark it with number of surrounding mine(s), stop further search.
     *  2.2 No surrounding mine, mark it as 'B', continue search its 8 neighbors.
     */
    public char[][] updateBoard(char[][] board, int[] click) {
        int m = board.length, n = board[0].length;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(click);

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int row = cell[0];
            int col = cell[1];

            if (board[row][col] == 'M') { // Mine
                board[row][col] = 'X';
            } else { // Empty
                // Get number of mines first.
                int count = 0;
                for (int i = -1; i < 2; i++) {
                    for (int j = -1; j < 2; j++) {
                        if (i == 0 && j == 0) {
                            continue;
                        }
                        int r = row + i;
                        int c = col + j;
                        if (r < 0 || r >= m || c < 0 || c < 0 || c >= n) {
                            continue;
                        }
                        if (board[r][c] == 'M' || board[r][c] == 'X') {
                            count++;
                        }
                    }
                }

                if (count > 0) { // If it is not a 'B', stop further BFS.
                    board[row][col] = (char) (count + '0');
                } else { // Continue BFS to adjacent cells.
                    board[row][col] = 'B';
                    for (int i = -1; i < 2; i++) {
                        for (int j = -1; j < 2; j++) {
                            if (i == 0 && j == 0) {
                                continue;
                            }
                            int r = row + i;
                            int c = col + j;
                            if (r < 0 || r >= m || c < 0 || c < 0 || c >= n) {
                                continue;
                            }
                            if (board[r][c] == 'E') {
                                queue.offer(new int[]{r, c});
                                board[r][c] = 'B'; // Avoid to be added again.
                            }
                        }
                    }
                }
            }
        }

        return board;
    }
}
