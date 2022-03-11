package com.jasper.binarysearch;

public class LC0410_SplitArrayLargestSum {

    public int splitArray(int[] nums, int m) {
        int sum = 0;
        int max = 0;
        for (int num : nums) {
            sum += num;
            max = Math.max(max, num);
        }

        return binarySearch(nums, m, max, sum);
    }

    public int binarySearch(int[] nums, int m, int low, int high) {
        int l = low;
        int r = high;

        while (l + 1 < r) {
            int mid = l + (r - l) / 2;
            if (isValid(nums, m, mid)) {
                r = mid;
            } else {
                l = mid;
            }
        }

        return isValid(nums, m, l) ? l : r;
    }

    public boolean isValid(int[] nums, int m, int target) {
        int cur = 0;
        int count = 1;

        for (int num : nums) {
            if (cur + num <= target) {
                cur += num;
            } else {
                count++;
                cur = num;
                if (count > m) {
                    return false;
                }
            }
        }

        return true;
    }
}
