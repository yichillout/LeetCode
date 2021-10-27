package com.jasper.binarysearch;

public class LC1539_KthMissingPositiveNumber {

    // solution 2 : O(n)
    public int findKthPositive(int[] arr, int k) {
        int j = 0;
        int count = 0;
        for (int i = 1; i < arr[arr.length - 1]; i++) {
            if (i == arr[j]) {
                j++;
            } else {
                count++;
            }

            if (count == k) {
                return i;
            }
        }

        // if count is 0, that means no missing between [1, arr[arr.length - 1]]
        return arr[arr.length - 1] + k - count;
    }
}
