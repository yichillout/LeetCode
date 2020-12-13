package com.jasper.array;

import java.util.ArrayList;
import java.util.List;

public class LC0054_SpiralMatrix {
	public List<Integer> spiralOrder(int[][] matrix) {

		List<Integer> result = new ArrayList<Integer>();

		if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
			return result;

		int rowStart = 0;
		int rowEnd = matrix.length - 1;
		int colStart = 0;
		int colEnd = matrix[0].length - 1;
		int dir = 0;

		while (rowStart <= rowEnd && colStart <= colEnd) {
			if (dir == 0) {
				for (int j = colStart; j <= colEnd; j++) {
					result.add(matrix[rowStart][j]);
				}
				dir = 1;
				rowStart++;
			} else if (dir == 1) {
				for (int i = rowStart; i <= rowEnd; i++) {
					result.add(matrix[i][colEnd]);
				}
				dir = 2;
				colEnd--;
			} else if (dir == 2) {
				for (int j = colEnd; j >= colStart; j--) {
					result.add(matrix[rowEnd][j]);
				}
				dir = 3;
				rowEnd--;
			} else if (dir == 3) {
				for (int i = rowEnd; i >= rowStart; i--) {
					result.add(matrix[i][colStart]);
				}
				dir = 0;
				colStart++;
			}
		}

		return result;
	}
}
