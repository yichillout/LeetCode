package com.jasper.stack;

import java.util.Arrays;
import java.util.Stack;

public class LC1504_CountSubmatricesWithAllOnes {

    // solution 1 : O(M * N * M):
    public int numSubmat1(int[][] mat) {
        int M = mat.length, N = mat[0].length;

        int res = 0;
        for (int up = 0; up < M; ++up) {
            int[] h = new int[N];
            Arrays.fill(h, 1);
            for (int down = up; down < M; ++down) {
                for (int k = 0; k < N; ++k) {
                    h[k] &= mat[down][k];
                }
                res += countOneRow(h);
            }
        }

        return res;
    }

    private int countOneRow(int[] A) {

        int res = 0, length = 0;
        for (int i = 0; i < A.length; ++i) {
            length = (A[i] == 0 ? 0 : length + 1);
            res += length;
        }
        return res;
    }

    // solution 2 : O(M * N)
    public int numSubmat2(int[][] mat) {
        int M = mat.length;
        int N = mat[0].length;

        int res = 0;
        int[] h = new int[N];

        for (int i = 0; i < M; ++i) {
            for (int j = 0; j < N; ++j) {
                if (mat[i][j] == 0) {
                    h[j] = 0;
                } else {
                    h[j] += 1;
                }
            }
            res += helper(h);
        }

        return res;
    }

    private int helper(int[] A) {
        int[] sum = new int[A.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < A.length; ++i) {

            while (!stack.isEmpty() && A[stack.peek()] >= A[i]) {
                stack.pop();
            }

            if (!stack.isEmpty()) {
                int preIndex = stack.peek();
                sum[i] = sum[preIndex];
                sum[i] += A[i] * (i - preIndex);
            } else {
                sum[i] = A[i] * (i + 1);
            }

            stack.push(i);
        }

        int res = 0;
        for (int s : sum) {
            res += s;
        }

        return res;
    }
}
