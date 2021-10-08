package com.jasper.backtracking;

public class LC0052_N_QueensII {

    int sum = 0;

    public int totalNQueens(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }

        helper(board, 0);
        return sum;
    }

    public void helper(char[][] board, int rowIndex) {
        if (rowIndex == board.length) {
            sum++;
            return;
        }

        for (int i = 0; i < board[0].length; i++) {
            if (isValid(board, rowIndex, i)) {
                board[rowIndex][i] = 'Q';
                helper(board, rowIndex + 1);
                board[rowIndex][i] = '.';
            }
        }
    }

    public boolean isValid(char[][] board, int rowIndex, int colIndex) {
        for (int i = 0; i < rowIndex; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'Q' && (j + rowIndex == i + colIndex || i + j == rowIndex + colIndex || j == colIndex)) {
                    return false;
                }
            }
        }

        return true;
    }
}
