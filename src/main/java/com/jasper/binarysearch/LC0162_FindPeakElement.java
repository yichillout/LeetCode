package com.jasper.binarysearch;

public class LC0162_FindPeakElement {

    // solution 1 : important
    public int findPeakElement1(int[] nums) {

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

    // solution 2
    public int findPeakElement2(int[] nums) {

        int lo = 0;
        int hi = nums.length - 1;

        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] > nums[mid + 1]) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }

}
