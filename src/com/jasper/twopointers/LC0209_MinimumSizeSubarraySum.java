package com.jasper.twopointers;

public class LC0209_MinimumSizeSubarraySum {
	public int minSubArrayLen(int s, int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;
		int sum = nums[0];
		int left = 0;
		int resLen = nums.length;
		boolean flag = false;
		for (int i = 0; i < nums.length;) {
			if (sum < s) {
				i++;
				if (i < nums.length)
					sum += nums[i];
			} else if (left < i) {
				resLen = Math.min(i - left + 1, resLen);
				sum -= nums[left];
				left++;
				flag = true;
			} else {
				return 1;
			}
		}
		return flag ? resLen : 0;
	}
}
