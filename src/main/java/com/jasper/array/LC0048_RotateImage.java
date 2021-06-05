package com.jasper.array;

public class LC0048_RotateImage {

	// Solution 1
	public void rotate1(int[][] matrix) {

		int temp = 0;

		// i: 0 -> n/2
		// j: 0 -> n
		for (int i = 0; i < matrix.length / 2; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				temp = matrix[i][j];
				matrix[i][j] = matrix[matrix.length - 1 - i][j];
				matrix[matrix.length - 1 - i][j] = temp;
			}
		}

		// i: 0 -> n
		// j: i+1 -> n
		for (int i = 0; i < matrix.length; i++) {
			for (int j = i + 1; j < matrix[0].length; j++) {
				temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp;
			}
		}

	}

	// Solution 2
	public void rotate2(int[][] matrix) {
		
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return;
		}

		int length = matrix.length;

		for (int i = 0; i < length / 2; i++) {
			for (int j = 0; j < (length + 1) / 2; j++) {
				int tmp = matrix[i][j];
				matrix[i][j] = matrix[length - j - 1][i];
				matrix[length - j - 1][i] = matrix[length - i - 1][length - j - 1];
				matrix[length - i - 1][length - j - 1] = matrix[j][length - i - 1];
				matrix[j][length - i - 1] = tmp;
			}
		}
	}

}
