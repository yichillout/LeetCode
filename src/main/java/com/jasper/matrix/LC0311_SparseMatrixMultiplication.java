package com.jasper.matrix;

public class LC0311_SparseMatrixMultiplication {

    /**
     * @param mat1
     * @param mat2
     * @return [4 * 2] * [2 * 3] = [4 * 3]
     * <p>
     * A00,A01                  C00,C01,C02
     * A10,A11 * B00,B01,B02 =  C10,C11,C12
     * A20,A21   B10,B11,B12    C20,C21,C22
     * A30,A31                  C30,C31,C32
     * <p>
     * C00 = A00 * B00 + A01 * B10
     * C10 = A10 * B00 + A11 * B10
     */
    public static int[][] multiply(int[][] mat1, int[][] mat2) {
        int mA = mat1.length;
        int nA = mat1[0].length;
        int nB = mat2[0].length;

        int[][] C = new int[mA][nB];

        for (int i = 0; i < mA; i++) {
            for (int k = 0; k < nA; k++) {
                if (mat1[i][k] != 0) {
                    for (int j = 0; j < nB; j++) {
                        if (mat2[k][j] != 0) {
                            C[i][j] += mat1[i][k] * mat2[k][j];
                        }
                    }
                }
            }
        }

        return C;
    }

    public static void main(String[] args) {
        int[][] mat1 = new int[][]{{1, 2, 3}, {4, 5, 6}};
        int[][] mat2 = new int[][]{{7, 8}, {9, 10}, {11, 12}};
        multiply(mat1, mat2);
    }
}
