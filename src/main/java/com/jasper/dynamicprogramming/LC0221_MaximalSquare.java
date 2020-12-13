package com.jasper.dynamicprogramming;

public class LC0221_MaximalSquare {

	public int maximalSquare(char[][] matrix) {

		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return 0;
		}

		int res = 0;
		int n = matrix.length;
		int m = matrix[0].length;
		int[][] f = new int[n][m];

		if (n == 1) {
			for (int j = 0; j < m; j++) {
				if (matrix[0][j] == '1') {
					return 1;
				}
			}
			return 0;
		}

		if (m == 1) {
			for (int i = 0; i < n; i++) {
				if (matrix[i][0] == '1') {
					return 1;
				}
			}
			return 0;
		}

		for (int i = 0; i < n; i++) {
			if (matrix[i][0] == '1') {
				f[i][0] = 1;
				res = 1;
			} else {
				f[i][0] = 0;
			}

		}

		for (int j = 0; j < m; j++) {
			if (matrix[0][j] == '1') {
				f[0][j] = 1;
				res = 1;
			} else {
				f[0][j] = 0;
			}
		}

		for (int i = 1; i < n; i++) {
			for (int j = 1; j < m; j++) {
				f[i][j] = 0;
				if (matrix[i][j] == '1') {
					f[i][j] = Math.min(f[i - 1][j - 1], Math.min(f[i - 1][j], f[i][j - 1])) + 1;
				} else {
					f[i][j] = 0;
				}
				if (f[i][j] > res) {
					res = f[i][j];
					System.out.println(res);
				}
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.print(f[i][j] + " ");
			}
			System.out.print("\n");
		}

		return res * res;
	}

}
