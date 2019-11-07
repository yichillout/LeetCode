package com.jasper.depthfirstsearch;

public class LC0079_WordSearch {
	
	public static boolean exist(char[][] board, String word) {

		if (board == null || board.length == 0 || board[0].length == 0) {
			return false;
		}

		int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (word.charAt(0) == board[i][j]) {
					if (search(board, word, i, j, dir, 0)) {
						return true;
					}
				}
			}
		}

		return false;
	}

	private static boolean search(char[][] board, String word, int x, int y, int[][] dir, int index) {

		if (index == word.length()) {
			return true;
		}

		if (x < 0 || x >= board.length || y < 0 || y >= board[0].length || board[x][y] == '#'
				|| board[x][y] != word.charAt(index)) {
			return false;
		}

		board[x][y] = '#';

		for (int i = 0; i < dir.length; i++) {
			if (search(board, word, x + dir[i][0], y + dir[i][1], dir, index + 1)) {
				return true;
			}
		}

		board[x][y] = word.charAt(index);

		return false;
	}

	public static void main(String[] args) {
		char[][] board = { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } };

		System.out.println(exist(board, "ABCCED"));
	}
}
