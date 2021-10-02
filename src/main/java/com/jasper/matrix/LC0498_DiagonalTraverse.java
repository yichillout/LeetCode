package com.jasper.matrix;

public class LC0498_DiagonalTraverse {

    public int[] findDiagonalOrder(int[][] mat) {

        if (mat == null || mat.length == 0) {
            return new int[0];
        }

        //Idea is the following
        //notice all values in the same diagonal share the same sum value of x index + y index
        //direction of going up right or going down left depends whether the index sum is even or odd
        //for each even or odd diagonal, there are three cases:
        // 1. there is room to go that direction
        // 2. there is no row space to go further but there is col space
        // 3. there is no col space to go further but there is row space

        int rows = mat.length;
        int cols = mat[0].length;
        int[] res = new int[rows * cols];
        int r = 0;
        int c = 0;

        for (int i = 0; i < rows * cols; i++) {
            res[i] = mat[r][c];
            // even sum diagonal
            if ((r + c) % 2 == 0) {
                if (r - 1 >= 0 && c + 1 < cols) {
                    c = c + 1;
                    r = r - 1;
                } else if (r - 1 < 0 && c + 1 < cols) {
                    c = c + 1;
                } else if (r + 1 < rows && c + 1 > cols - 1) {
                    r = r + 1;
                }
            }
            // odd sum diagonal
            else if ((r + c) % 2 != 0) {
                if (r + 1 < rows && c - 1 >= 0) {
                    c = c - 1;
                    r = r + 1;
                } else if (r + 1 < rows && c - 1 < 0) {
                    r = r + 1;
                } else if (r + 1 > rows - 1 && c + 1 < cols) {
                    c = c + 1;
                }
            }
        }
        return res;
    }
}
