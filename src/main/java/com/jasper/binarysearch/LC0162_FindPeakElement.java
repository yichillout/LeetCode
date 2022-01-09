package com.jasper.binarysearch;

public class LC0162_FindPeakElement {

    public int findPeakElement(int[] nums) {
        int l = 0;
        int r = nums.length - 1;

        while (l + 1 < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] < nums[mid + 1]) {
                l = mid;
            } else {
                r = mid;
            }
        }

        return nums[r] > nums[l] ? r : l;
    }
}
