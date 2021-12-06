package com.jasper.design;

class NumArray {

    int[] prefixSums;

    public NumArray(int[] nums) {
        prefixSums = new int[nums.length + 1];
        prefixSums[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            prefixSums[i + 1] = prefixSums[i] + nums[i];
        }
    }

    public int sumRange(int left, int right) {
        return prefixSums[right + 1] - prefixSums[left];
    }
}

public class LC0303_RangeSumQueryImmutable {
}
