package com.jasper.dynamicprogramming;

public class LC0198_HouseRobber {

	public int rob(int[] nums) {

		if (nums == null || nums.length == 0)
			return 0;

		if (nums.length == 1)
			return nums[0];

		if (nums.length == 2)
			return nums[0] > nums[1] ? nums[0] : nums[1];

		int[] result = new int[nums.length];
		result[0] = nums[0];
		result[1] = Math.max(nums[1], nums[0]);

		for (int i = 2; i < result.length; i++) {
			result[i] = Math.max(nums[i] + result[i - 2], result[i - 1]);
		}

		return result[result.length - 1];
	}

}
