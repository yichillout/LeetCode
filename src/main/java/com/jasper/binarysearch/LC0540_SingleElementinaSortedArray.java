package com.jasper.binarysearch;

public class LC0540_SingleElementinaSortedArray {

    /**
     * @param nums
     * @return
	 *
	 * example 1
     * 1 1 2 2 3 4 4
     * 0 1 2 3 4 5 6
     *
     * example 2
     * 1 1 3 2 2
     * 0 1 2 3 4
     */

    public int singleNonDuplicate(int[] nums) {

        int l = 0;
        int r = nums.length - 1;

        if (l == r) {
            return nums[0];
        } else if (nums[0] != nums[1]) {
            return nums[0];
        } else if (nums[r] != nums[r - 1]) {
            return nums[r];
        }

        while (l + 1 < r) {
            int mid = l + (r - l) / 2;
            if (((mid % 2) == 0 && nums[mid] == nums[mid + 1])
                    || ((mid % 2) == 1 && nums[mid] == nums[mid - 1])) {
                l = mid;
            } else {
                r = mid;
            }
        }

        if (nums[l] != nums[l - 1] && nums[l] != nums[l + 1]) {
            return nums[l];
        }

        if (nums[r] != nums[r - 1] && nums[r] != nums[r + 1]) {
            return nums[r];
        }

        return -1;
    }

}
