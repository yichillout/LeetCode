package com.jasper.greedy;

public class LC0045_JumpGameII {

	public static int jump(int[] nums) {

		int max = 0;
		int start = 0;
		int end = 0;
		int step = 0;

		while (end < nums.length - 1) {
			step++;
			for (int i = start; i <= end; i++) {
				if (i + nums[i] > max) {
					max = i + nums[i];
				}
			}
			start = end + 1;
			end = max;
		}

		return step;

	}

	public static void main(String[] args) {
		int[] nums = { 3, 3, 1, 1, 4 };

		System.out.println(jump(nums));
	}
}
