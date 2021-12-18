package com.jasper.prefixSum;

public class LC1343_NumberOfSubArraysOfSizeKAndAverageGreaterThanOrEqualToThreshold {

    public int numOfSubarrays(int[] arr, int k, int threshold) {

        int[] prefixSums = new int[arr.length + 1];

        for (int i = 0; i < arr.length; i++) {
            prefixSums[i + 1] = prefixSums[i] + arr[i];
        }

        int count = 0;
        for (int i = 0; i <= arr.length - k; i++) {
            if ((prefixSums[i + k] - prefixSums[i]) / k >= threshold) {
                count++;
            }
        }

        return count;
    }
}
