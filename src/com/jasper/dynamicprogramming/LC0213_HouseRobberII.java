package com.jasper.dynamicprogramming;

public class LC0213_HouseRobberII {

	public int rob(int[] nums) {

		if (nums == null || nums.length == 0)
			return 0;

		if (nums.length == 1)
			return nums[0];

		return Math.max(robHelper(nums, 0, nums.length - 2), robHelper(nums, 1, nums.length - 1));
	}

	public int robHelper(int[] nums, int lo, int hi) {

		if (lo == hi)
			return nums[lo];

		int[] result = new int[nums.length];
		result[lo] = nums[lo];
		result[lo + 1] = Math.max(nums[lo + 1], nums[lo]);

		for (int i = lo + 2; i <= hi; i++) {
			result[i] = Math.max(result[i - 1], nums[i] + result[i - 2]);
		}

		return result[hi];
	}
}
