package com.jasper.binarysearch;

public class LC0035_SearchInsertPosition {

    public static int searchInsert(int[] nums, int target) {

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

        if (nums[l] >= target) {
            return l;
        } else if (nums[r] >= target) {
            return r;
        }

        return r + 1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};
        int target = 7;
        System.out.println(searchInsert(nums, target));
    }
}
