package com.jasper.prefixSum;

public class LC0370_RangeAddition {

    /**
     * Input: length = 5, updates = [[1,3,2],[2,4,3],[0,2,-2]]
     * Output: [-2,0,3,5,3]
     * <p>
     * res [ 0, 2, 0, 0,-2]
     * res [ 0, 2, 3, 0,-2]
     * res [-2, 2, 3, 2,-2]
     */

    public static int[] getModifiedArray(int length, int[][] updates) {
        int[] res = new int[length];

        for (int[] update : updates) {
            int value = update[2];
            int start = update[0];
            int end = update[1];
            res[start] += value;
            if (end + 1 < length) {
                res[end + 1] -= value;
            }
        }

        int sum = 0;
        for (int i = 0; i < length; i++) {
            sum += res[i];
            res[i] = sum;
        }

        return res;
    }

    public static void main(String[] args) {
        getModifiedArray(5, new int[][]{{1, 3, 2}, {2, 4, 3}, {0, 2, -2}});
    }
}
