package com.jasper.array;

public class LC0073_SetMatrixZeroes {

	public static void setZeroes1(int[][] matrix) {

		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return;
		}

		boolean[] row = new boolean[matrix.length];
		boolean[] column = new boolean[matrix[0].length];

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] == 0) {
					row[i] = true;
					column[j] = true;
				}
			}
		}

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (row[i] || column[j]) {
					matrix[i][j] = 0;
				}
			}
		}
	}

	public static void main(String[] args) {

		int[][] matrix = { { 1, 1, 1, 0 }, { 1, 1, 1, 0 }, { 1, 1, 0, 0 },
				{ 1, 0, 0, 0 }, };

		setZeroes1(matrix);
	}
}
