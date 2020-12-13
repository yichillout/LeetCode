package com.jasper.hashtable;

public class LC0037_SudokuSolver {
	public static void solveSudoku(char[][] board) {
		fillboard(board, 0, 0);
	}

	public static boolean fillboard(char[][] board, int i, int j) {
		if (i == 9)
			return true;
		if (j == 9)
			return fillboard(board, i + 1, 0);
		if (board[i][j] == '.') {
			for (int k = 1; k <= 9; k++) {
				board[i][j] = (char) (k + '0');
				if (isValid(board, i, j)) {
					if (fillboard(board, i, j + 1))
						return true;
				}
				board[i][j] = '.';
			}
		} else
			return fillboard(board, i, j + 1);
		return false;
	}

	public static boolean isValid(char[][] board, int i, int j) {
		for (int k = 0; k < 9; k++) {
			if (k != j && board[i][k] == board[i][j])
				return false;
		}
		for (int k = 0; k < 9; k++) {
			if (k != i && board[k][j] == board[i][j])
				return false;
		}
		for (int row = i / 3 * 3; row < i / 3 * 3 + 3; row++) {
			for (int col = j / 3 * 3; col < j / 3 * 3 + 3; col++) {
				if ((row != i || col != j) && board[row][col] == board[i][j])
					return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		char[][] sudoku = { 
				{ '5', '3', 0, 0, '7', 0, 0, 0, 0 },
				{ '6', 0, 0, '1', '9', '5', 0, 0, 0 }, 
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, '6', 0, '8', 0, 0 }, 
				{ 0, '4', 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, '5', '3', 0, 0, 0, 0, '7' }, 
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, '2', 0, 0, 0, 0, '6', 0, 0 }, 
				{ 0, 0, '7', '5', 0, '9', 0, 0, 0 } };
		
		solveSudoku(sudoku);
	}

}
