package com.jasper.backtracking;

import java.util.ArrayList;
import java.util.List;

public class LC0051_N_Queens {

    public List<List<String>> solveNQueens(int n) {

        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }

        List<List<String>> res = new ArrayList<>();
        dfs(board, 0, res);
        return res;
    }

    public void dfs(char[][] board, int rowIndex, List<List<String>> res) {
        if (rowIndex == board.length) {
            res.add(construct(board));
            return;
        }

        for (int i = 0; i < board[0].length; i++) {
            if (isValid(board, rowIndex, i)) {
                board[rowIndex][i] = 'Q';
                dfs(board, rowIndex + 1, res);
                board[rowIndex][i] = '.';
            }
        }
    }

    public boolean isValid(char[][] board, int x, int y) {
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'Q' && (x + j == y + i || x + y == i + j || y == j)) {
                    return false;
                }
            }
        }
        return true;
    }

    public List<String> construct(char[][] board) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            res.add(new String(board[i]));
        }
        return res;
    }
}
