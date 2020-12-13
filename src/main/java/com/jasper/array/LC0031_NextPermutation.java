package com.jasper.array;

public class LC0031_NextPermutation {
	public void nextPermutation(int[] nums) {

		if (nums == null || nums.length == 0)
			return;

		for (int i = nums.length - 2; i >= 0; i--) {
			if (nums[i] < nums[i + 1]) {
				for (int j = nums.length - 1; j > i; j--) {
					if (nums[i] < nums[j]) {
						int temp = nums[i];
						nums[i] = nums[j];
						nums[j] = temp;
						reverse(nums, i + 1, nums.length - 1);
						return;
					}
				}
			}
		}
		reverse(nums, 0, nums.length - 1);

	}

	public void reverse(int[] nums, int lo, int hi) {

		while (lo < hi) {
			int temp = nums[lo];
			nums[lo] = nums[hi];
			nums[hi] = temp;
			lo++;
			hi--;
		}

	}
}
