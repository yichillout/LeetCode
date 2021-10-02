package com.jasper.binarysearch;

import java.util.Arrays;

public class LC0259_3SumSmaller {

    public int threeSumSmaller(int[] nums, int target) {
        int count = 0;

        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                int index = findLastLess(nums, j + 1, nums.length - 1, target - nums[i] - nums[j]);
                if (index != -1) {
                    count += index - j;
                }
            }
        }

        return count;
    }

    public int findLastLess(int[] nums, int l, int h, int target) {
        while (l + 1 < h) {
            int mid = l + (h - l) / 2;
            if (nums[mid] < target) {
                l = mid;
            } else {
                h = mid;
            }
        }

        if (nums[h] < target) {
            return h;
        }

        if (nums[l] < target) {
            return l;
        }

        return -1;
    }
}
