package com.jasper.dynamicprogramming;

public class LC0300_LongestIncreasingSubsequence {

    // solution 1 : DP
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int result = 1;
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            result = Math.max(result, dp[i]);
        }

        return result;
    }

    // solution 2 : binary search TODO
    public static int lengthOfLIS2(int[] nums) {
        if (nums == null | nums.length == 0) {
            return 0;
        }

        int n = nums.length;
        int len = 0;
        int[] increasingSequence = new int[n];
        increasingSequence[len++] = nums[0];

        for (int i = 1; i < n; i++) {
            if (nums[i] > increasingSequence[len - 1]) {
                increasingSequence[len++] = nums[i];
            } else {
                int position = findPositionToReplace(increasingSequence, 0, len - 1, nums[i]);
                increasingSequence[position] = nums[i];
            }
        }

        return len;
    }

    public static int findPositionToReplace(int[] a, int low, int high, int x) {
        int mid;
        while (low <= high) {
            mid = low + (high - low) / 2;
            if (a[mid] == x)
                return mid;
            else if (a[mid] > x)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return low;
    }
}
