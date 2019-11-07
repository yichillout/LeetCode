package com.jasper.dynamicprogramming;

public class LC0064_MinimumPathSum {

	public int minPathSum(int[][] grid) {

		if (grid == null || grid.length == 0 || grid[0].length == 0)
			return 0;

		int[][] result = new int[grid.length][grid[0].length];

		result[0][0] = grid[0][0];

		for (int i = 1; i < grid.length; i++) {
			result[i][0] = result[i - 1][0] + grid[i][0];
		}

		for (int j = 1; j < grid[0].length; j++) {
			result[0][j] = result[0][j - 1] + grid[0][j];
		}

		for (int i = 1; i < grid.length; i++) {
			for (int j = 1; j < grid[0].length; j++) {
				result[i][j] = grid[i][j] + Math.min(result[i - 1][j], result[i][j - 1]);
			}
		}

		return result[result.length - 1][result[0].length - 1];

	}
}
