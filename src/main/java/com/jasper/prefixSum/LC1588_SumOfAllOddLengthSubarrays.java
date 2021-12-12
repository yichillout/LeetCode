package com.jasper.prefixSum;

public class LC1588_SumOfAllOddLengthSubarrays {

    public int sumOddLengthSubarrays(int[] arr) {

        int[] prefixSums = new int[arr.length + 1];

        for (int i = 0; i < arr.length; i++) {
            prefixSums[i + 1] = prefixSums[i] + arr[i];
        }

        int sum = 0;

        int i = 0;
        while (i < arr.length) {
            for (int j = 0; j < arr.length - i; j++) {
                sum += prefixSums[j + i + 1] - prefixSums[j];
            }
            i += 2;
        }

        return sum;
    }
}
