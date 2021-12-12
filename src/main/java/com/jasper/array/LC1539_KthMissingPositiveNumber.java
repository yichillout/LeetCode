package com.jasper.array;

public class LC1539_KthMissingPositiveNumber {

    public int findKthPositive(int[] arr, int k) {
        int count = 0;
        int index = 0;

        for (int i = 1; i < arr[arr.length - 1]; i++) {
            if (i == arr[index]) {
                index++;
            } else {
                count++;
            }

            if (count == k) {
                return i;
            }
        }

        return arr[arr.length - 1] + k - count;
    }
}
