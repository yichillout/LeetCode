package com.jasper.slidingwindow;

import java.util.Arrays;

public class LC1477_FindTwoNonOverlappingSubArraysEachWithTargetSum {

    /**
     * [1,6,1] target = 7
     * best: [2147483647,2,2]
     * if (j > 0 && best[j - 1] != Integer.MAX_VALUE)
     */
    public static int minSumOfLengths(int[] arr, int target) {
        int n = arr.length;
        int best[] = new int[n]; // best array is to avoid over lap

        Arrays.fill(best, Integer.MAX_VALUE);

        int sum = 0;
        int min = Integer.MAX_VALUE;
        int curMin = Integer.MAX_VALUE;

        int j = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];

            while (sum > target) {
                sum -= arr[j];
                j++;
            }

            if (sum == target) {
                if (j > 0 && best[j - 1] != Integer.MAX_VALUE) {
                    min = Math.min(min, best[j - 1] + i - j + 1);
                }
                curMin = Math.min(curMin, i - j + 1);
            }

            best[i] = curMin;
        }

        return min == Integer.MAX_VALUE ? -1 : min;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3, 1, 1, 1, 5, 1, 2, 1};
        int target = 3;
        minSumOfLengths(arr, target);
    }
}
