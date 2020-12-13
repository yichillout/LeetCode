package com.jasper.depthfirstsearch;

public class LC0329_LongestIncreasingPathinaMatrix {

	public int[][] dirs = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

	public int longestIncreasingPath(int[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
			return 0;

		int[][] cache = new int[matrix.length][matrix[0].length];

		int max = 1;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				int len = dfs(matrix, i, j, cache);
				max = Math.max(max, len);
			}
		}
		return max;
	}

	public int dfs(int[][] matrix, int i, int j, int[][] cache) {

		if (cache[i][j] != 0)
			return cache[i][j];

		int localMax = 1;
		for (int[] dir : dirs) {
			int x = i + dir[0];
			int y = j + dir[1];
			if (x >= 0 && x < matrix.length && y >= 0 && y < matrix[0].length && matrix[i][j] < matrix[x][y]) {
				int len = 1 + dfs(matrix, x, y, cache);
				localMax = Math.max(localMax, len);
			}
		}
		cache[i][j] = localMax;
		return localMax;
	}
}
