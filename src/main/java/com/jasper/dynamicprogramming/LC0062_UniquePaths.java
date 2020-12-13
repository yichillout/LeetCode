package com.jasper.dynamicprogramming;

public class LC0062_UniquePaths {

	// Solution 1
	public int uniquePaths1(int m, int n) {

		if (m == 0 || n == 0)
			return 0;

		if (m == 1 || n == 1) {
			return 1;
		}

		int[][] grid = new int[m][n];

		for (int i = 0; i < m; i++) {
			grid[i][0] = 1;
		}

		for (int j = 0; j < n; j++) {
			grid[0][j] = 1;
		}

		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				grid[i][j] = grid[i - 1][j] + grid[i][j - 1];
			}
		}

		return grid[grid.length - 1][grid[0].length - 1];
	}

	// Solution 2
	public int uniquePaths2(int m, int n) {
		int[] ways = new int[n];
		ways[0] = 1;
		for (int i = 0; i < m; i++)
			for (int j = 1; j < n; j++)
				ways[j] += ways[j - 1];
		return ways[n - 1];
	}
}