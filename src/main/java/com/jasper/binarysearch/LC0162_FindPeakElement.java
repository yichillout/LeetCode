package com.jasper.binarysearch;

public class LC0162_FindPeakElement {

    // find max
    public static int findPeakElement(int[] nums) {
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

    // find min
    public static int findElement(int[] nums) {
        int l = 0;
        int r = nums.length - 1;

        while (l + 1 < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] < nums[mid + 1]) {
                r = mid;
            } else {
                l = mid;
            }
        }

        return nums[r] < nums[l] ? r : l;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 1, 3, 0, 6, 4};
        System.out.println(findElement(nums));
    }
}
