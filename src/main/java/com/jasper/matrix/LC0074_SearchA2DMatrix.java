package com.jasper.matrix;

public class LC0074_SearchA2DMatrix {

    // solution 1 : search it from [0, matrix[0].length - 1]
    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return false;

        int m = matrix.length;
        int n = matrix[0].length;

        if (target < matrix[0][0] || target > matrix[m - 1][n - 1])
            return false;

        int row = 0;
        int col = matrix[0].length - 1;

        while (row < m && col >= 0) {
            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] < target) {
                row++;
            } else {
                col--;
            }
        }

        return false;
    }

    // solution 2 : binary search
    public boolean searchMatrix2(int[][] matrix, int target) {

        int m = matrix.length;
        int n = matrix[0].length;

        int l = 0;
        int r = m * n - 1;

        while (l + 1 < r) {
            int mid = l + (r - l) / 2;
            if (getNum(matrix, mid) <= target) {
                l = mid;
            } else {
                r = mid;
            }
        }

        if (getNum(matrix, l) == target) {
            return true;
        }

        if (getNum(matrix, r) == target) {
            return true;
        }

        return false;
    }

    public int getNum(int[][] matrix, int index) {
        int row = index / matrix[0].length;
        int col = index % matrix[0].length;
        return matrix[row][col];
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 3}};
        System.out.println(searchMatrix(matrix, 2));
    }
}
