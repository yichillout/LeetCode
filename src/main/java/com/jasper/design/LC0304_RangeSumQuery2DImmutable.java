package com.jasper.design;

class NumMatrix {
    int[][] prefixMatrix;

    public NumMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        prefixMatrix = new int[m + 1][n + 1];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                prefixMatrix[i + 1][j + 1] = prefixMatrix[i][j + 1] + prefixMatrix[i + 1][j] - prefixMatrix[i][j] + matrix[i][j];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return prefixMatrix[row2 + 1][col2 + 1] - prefixMatrix[row1][col2 + 1] - prefixMatrix[row2 + 1][col1] + prefixMatrix[row1][col1];
    }
}

public class LC0304_RangeSumQuery2DImmutable {

}
