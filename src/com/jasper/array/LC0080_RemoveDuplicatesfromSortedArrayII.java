package com.jasper.array;

public class LC0080_RemoveDuplicatesfromSortedArrayII {

	public static int removeDuplicates(int[] nums) {
		if (nums == null) {
			return 0;
		}

		if (nums.length <= 2) {
			return nums.length;
		}

		int index = 0;
		for (int i = 0; i < nums.length; i++) {
			if (i > 0 && i < (nums.length - 1) && nums[i] == nums[i - 1] && nums[i] == nums[i + 1]) {
				continue;
			}
			nums[index] = nums[i];
			index++;
		}
		return index;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 1, 1, 2, 2, 3 };
		System.out.println(removeDuplicates(nums));
	}

}
