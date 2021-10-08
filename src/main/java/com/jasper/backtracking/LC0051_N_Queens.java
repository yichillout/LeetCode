package com.jasper.backtracking;

import java.util.ArrayList;
import java.util.List;

public class LC0051_N_Queens {

    public List<List<String>> solveNQueens(int n) {

        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }

        helper(board, 0, result);

        return result;
    }

    public void helper(char[][] board, int rowIndex, List<List<String>> result) {

        if (rowIndex == board.length) {
            List<String> list = new ArrayList<>();
            for (char[] b : board) {
                list.add(new String(b));
            }
            result.add(list);
            return;
        }


        for (int i = 0; i < board[0].length; i++) {
            if (isValid(board, rowIndex, i)) {
                board[rowIndex][i] = 'Q';
                helper(board, rowIndex + 1, result);
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
