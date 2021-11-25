package com.jasper.binarysearch;

public class LC0033_SearchInRotatedSortedArray {

    public static int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;

        while (l + 1 < r) {
            int mid = l + (r - l) / 2;
            if (nums[l] < nums[mid]) {
                if (nums[l] <= target && target <= nums[mid]) {
                    r = mid;
                } else {
                    l = mid;
                }
            } else {
                if (nums[mid] <= target && target <= nums[r]) {
                    l = mid;
                } else {
                    r = mid;
                }
            }
        }

        if (nums[l] == target) {
            return l;
        }

        if (nums[r] == target) {
            return r;
        }

        return -1;
    }

    public static void main(String[] args) {
        // int[] nums = { 3, 1 };
        // int[] nums = { 6, 7, 0, 1, 2, 4, 5 };
        int[] nums = {3, 5, 1};
        System.out.println(search(nums, 5));

    }
}
