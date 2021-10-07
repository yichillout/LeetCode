package com.jasper.heap;

public class LC0378_KthSmallestElementInSortedMatrix {

    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int l = matrix[0][0];
        int r = matrix[n - 1][n - 1];

        while (l <= r) {
            int mi = l + ((r - l) >> 1);
            int count = countLessOrEqual(mi, matrix);
            if (count < k) {
                l = mi + 1;
            } else {
                r = mi - 1;
            }
        }

        return l;
    }

    int countLessOrEqual(int x, int[][] matrix) {
        int count = 0;
        int N = matrix.length;
        int M = matrix[0].length - 1; // start with the rightmost column

        for (int r = 0; r < N; r++) {
            while (M >= 0 && matrix[r][M] > x) {
                M--;  // decrease column until matrix[r][c] <= x
            }

            count += (M + 1);
        }
        return count;
    }
}