package com.jasper.breadthfirstsearch;

import java.util.*;

public class LC0130_SurroundedRegions {

	public void solve(char[][] board) {

		if (board == null || board.length == 0 || board[0].length == 0)
			return;

		int n = board.length;
		int m = board[0].length;
		int[][] dir = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

		for (int i = 0; i < n; i++) {
			dfs(board, i, 0, dir);
			dfs(board, i, board[0].length - 1, dir);
		}

		for (int j = 1; j < board[0].length - 1; j++) {
			dfs(board, 0, j, dir);
			dfs(board, board.length - 1, j, dir);
		}

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == 'O') {
					board[i][j] = 'X';
				}
				if (board[i][j] == '#') {
					board[i][j] = 'O';
				}
			}
		}
	}

	private void dfs(char[][] board, int x, int y, int[][] dir) {
		if (x < board.length && x >= 0 && y < board[0].length && y >= 0 && board[x][y] == 'O') {

			board[x][y] = '#';

			for (int i = 0; i < 4; i++) {
				int xx = x + dir[i][0];
				int yy = y + dir[i][1];
				dfs(board, xx, yy, dir);
			}
		}
	}

}
