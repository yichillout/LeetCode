package com.jasper.binarysearch;

public class LC0540_SingleElementinaSortedArray {

	public int singleNonDuplicate(int[] nums) {

		if (nums == null || nums.length == 0)
			return 0;

		int lo = 0;
		int hi = nums.length / 2;

		while (lo < hi) {
			int mid = (lo + hi) / 2;
			if (nums[mid * 2] < nums[mid * 2 + 1]) {
				hi = mid;
			} else {
				lo = mid + 1;
			}
		}

		return nums[lo * 2];
	}

}
