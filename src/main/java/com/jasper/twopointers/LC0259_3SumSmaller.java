package com.jasper.twopointers;

import java.util.*;

public class LC0259_3SumSmaller {

	public int threeSumSmaller(int[] nums, int target) {

		if (nums == null || nums.length < 3)
			return 0;

		Arrays.sort(nums);
		int count = 0;

		for (int i = 0; i < nums.length - 2; i++) {

			int lo = i + 1;
			int hi = nums.length - 1;

			while (lo < hi) {
				int tempSum = nums[i] + nums[lo] + nums[hi];
				if (tempSum < target) {
					count += hi - lo;
					lo++;
				} else if (tempSum >= target) {
					hi--;
				}
			}
		}
		return count;

	}

}
