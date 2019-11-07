package com.jasper.array;

public class LC0026_RemoveDuplicatesfromSortedArray {

	public int removeDuplicates(int[] nums) {

		if (nums.length < 2)
			return nums.length;

		int index = 0;
		for (int i = 0; i < nums.length - 1; i++) {
			if (nums[i] != nums[i + 1]) {
				index++;
				nums[index] = nums[i + 1];
			}
		}

		return index + 1;
	}
}
