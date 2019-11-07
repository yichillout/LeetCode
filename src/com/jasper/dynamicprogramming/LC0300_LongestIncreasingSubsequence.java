package com.jasper.dynamicprogramming;

public class LC0300_LongestIncreasingSubsequence {

	public int lengthOfLIS(int[] nums) {

		if (nums == null || nums.length == 0)
			return 0;

		int[] dp = new int[nums.length];
		dp[0] = 1;

		for (int i = 1; i < nums.length; i++) {
			int counter = 1;
			int tmpMax = 0;
			for (int j = i - 1; j >= 0; j--) {
				if (nums[j] < nums[i] && tmpMax < dp[j]) {
					tmpMax = dp[j];
				}
			}
			dp[i] = tmpMax + 1;
		}

		int res = 0;
		for (int i = 0; i < dp.length; i++) {
			if (dp[i] > res) {
				res = dp[i];
			}
		}

		return res;
	}

}
