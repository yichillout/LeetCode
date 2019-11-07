package com.jasper.array;

public class LC0059_SpiralMatrixII {

	public int[][] generateMatrix(int n) {

		if (n < 1)
			return new int[0][0];

		int[][] result = new int[n][n];

		int rowStart = 0;
		int rowEnd = n - 1;
		int colStart = 0;
		int colEnd = n - 1;
		int num = 1;
		int dir = 0;

		while (rowStart <= rowEnd && colStart <= colEnd) {
			if (dir == 0) {
				for (int i = colStart; i <= colEnd; i++) {
					result[rowStart][i] = num;
					num++;
				}
				rowStart++;
				dir = 1;
			} else if (dir == 1) {
				for (int j = rowStart; j <= rowEnd; j++) {
					result[j][colEnd] = num;
					num++;
				}
				colEnd--;
				dir = 2;
			} else if (dir == 2) {
				for (int i = colEnd; i >= colStart; i--) {
					result[rowEnd][i] = num;
					num++;
				}
				rowEnd--;
				dir = 3;
			} else if (dir == 3) {
				for (int j = rowEnd; j >= rowStart; j--) {
					result[j][colStart] = num;
					num++;
				}
				colStart++;
				dir = 0;
			}
		}

		return result;
	}

}
