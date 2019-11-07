package com.jasper.array;

public class LC0189_RotateArray {
	public void rotate(int[] nums, int k) {

		if (nums == null || nums.length == 0)
			return;

		k = k % nums.length;

		rotateHelper(nums, 0, nums.length - 1);
		rotateHelper(nums, 0, k - 1);
		rotateHelper(nums, k, nums.length - 1);
	}

	public void rotateHelper(int[] nums, int left, int right) {

		while (left < right) {
			int temp = nums[left];
			nums[left] = nums[right];
			nums[right] = temp;
			left++;
			right--;
		}

	}
}
