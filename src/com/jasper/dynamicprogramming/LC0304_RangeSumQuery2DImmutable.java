package com.jasper.dynamicprogramming;

class NumMatrix {

    int[][] dp;

    public NumMatrix(int[][] matrix) {

        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return;

        dp = new int[matrix.length + 1][matrix[0].length + 1];
        for (int i = 1; i < matrix.length + 1; i++) {
            for (int j = 1; j < matrix[0].length + 1; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1] + matrix[i - 1][j - 1];
            }
        }

    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int colMax = Math.max(col1, col2) + 1;
        int colMin = Math.min(col1, col2) + 1;

        int rowMax = Math.max(row1, row2) + 1;
        int rowMin = Math.min(row1, row2) + 1;

        return dp[rowMax][colMax] - dp[rowMax][colMin - 1] - dp[rowMin - 1][colMax] + dp[rowMin - 1][colMin - 1];
    }
}

public class LC0304_RangeSumQuery2DImmutable {

}
