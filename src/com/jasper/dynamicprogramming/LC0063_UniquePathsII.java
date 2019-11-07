package com.jasper.dynamicprogramming;

public class LC0063_UniquePathsII {

	public int uniquePathsWithObstacles(int[][] obstacleGrid) {

		// obstacleGrid[0][0] == 1 is important
		if (obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0][0] == 1) {
			return 0;
		}

		int rowNum = obstacleGrid.length, colNum = obstacleGrid[0].length;

		for (int i = 0; i < rowNum; i++) {
			if (obstacleGrid[i][0] == 1) {
				for (int k = i; k < rowNum; k++) {
					obstacleGrid[k][0] = 0;
				}
				break;
			} else {
				obstacleGrid[i][0] = 1;
			}
		}

		// obstacleGrid[0][0] has been set!!!! so j = 1
		for (int j = 1; j < colNum; j++) {
			if (obstacleGrid[0][j] == 1) {
				for (int k = j; k < colNum; k++) {
					obstacleGrid[0][k] = 0;
				}
				break;
			} else {
				obstacleGrid[0][j] = 1;
			}
		}

		for (int i = 1; i < rowNum; i++) {
			for (int j = 1; j < colNum; j++) {
				if (obstacleGrid[i][j] == 1) {
					obstacleGrid[i][j] = 0;
				} else {
					obstacleGrid[i][j] = obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1];
				}

			}
		}

		return obstacleGrid[rowNum - 1][colNum - 1];
	}
}
