package com.jasper.prefixSum;

public class LC1031_MaximumSumOfTwoNonOverlappingSubarrays {

    public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {

        int[] prefixSums = new int[nums.length + 1];

        for (int i = 0; i < nums.length; i++) {
            prefixSums[i + 1] = prefixSums[i] + nums[i];
        }

        int max = Integer.MIN_VALUE;

        int maxLeft = prefixSums[firstLen];
        // firstLen is before secondLen
        for (int i = firstLen; i <= nums.length - secondLen; i++) {
            maxLeft = Math.max(maxLeft, prefixSums[i] - prefixSums[i - firstLen]);
            int right = prefixSums[i + secondLen] - prefixSums[i];
            max = Math.max(max, maxLeft + right);
        }

        maxLeft = prefixSums[secondLen];
        // secondLen is before firstLen
        for (int i = secondLen; i <= nums.length - firstLen; i++) {
            maxLeft = Math.max(maxLeft, prefixSums[i] - prefixSums[i - secondLen]);
            int right = prefixSums[i + firstLen] - prefixSums[i];
            max = Math.max(max, maxLeft + right);
        }

        return max;
    }
}
