package com.jasper.binarysearch;

public class LC0034_SearchforaRange {

    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }

        int l = 0;
        int r = nums.length - 1;

        while (l + 1 < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] >= target) {
                r = mid;
            } else {
                l = mid;
            }
        }

        int index1 = -1;
        if (nums[l] == target) {
            index1 = l;
        } else if (nums[r] == target) {
            index1 = r;
        }

        if (index1 == -1) {
            return new int[]{-1, -1};
        }


        l = index1;
        r = nums.length - 1;

        while (l + 1 < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] <= target) {
                l = mid;
            } else {
                r = mid;
            }
        }

        int index2 = -1;
        if (nums[r] == target) {
            index2 = r;
        } else if (nums[l] == target) {
            index2 = l;
        }

        return new int[]{index1, index2};
    }
}
