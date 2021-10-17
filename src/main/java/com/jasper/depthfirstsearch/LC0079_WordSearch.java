package com.jasper.depthfirstsearch;

public class LC0079_WordSearch {

    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (word.charAt(0) == board[i][j] && helper(0, i, j, board, new boolean[n][m], word)) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean helper(int index, int x, int y, char[][] board, boolean[][] visited, String word) {
        if (word.charAt(index) != board[x][y]) {
            return false;
        }

        if (index == word.length() - 1) {
            return true;
        }

        visited[x][y] = true;

        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        boolean isFound = false;
        for (int i = 0; i < dirs.length; i++) {
            int xx = x + dirs[i][0];
            int yy = y + dirs[i][1];
            if (xx >= 0 && xx < board.length && yy >= 0 && yy < board[0].length && !visited[xx][yy]) {
                isFound |= helper(index + 1, xx, yy, board, visited, word);
            }
        }

        visited[x][y] = false;
        return isFound;
    }
}
