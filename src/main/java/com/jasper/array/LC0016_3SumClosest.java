package com.jasper.array;

import java.util.Arrays;

public class LC0016_3SumClosest {
	
	public int threeSumClosest(int[] nums, int target) {

		if (nums == null || nums.length == 0)
			return Integer.MAX_VALUE;

		Arrays.sort(nums);
		
		int min = Integer.MAX_VALUE;
		int result = 0;

		for (int i = 0; i < nums.length - 2; i++) {

			int lo = i + 1;
			int hi = nums.length - 1;

			while (lo < hi) {
				int tempTarget = nums[i] + nums[lo] + nums[hi];
				if (tempTarget == target) {
					return tempTarget;
				} else if (tempTarget > target) {
					hi--;
				} else {
					lo++;
				}

				if (Math.abs(tempTarget - target) < min) {
					min = Math.abs(tempTarget - target);
					result = tempTarget;
				}

			}
		}

		return result;

	}
}
