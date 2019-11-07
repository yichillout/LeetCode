package com.jasper.array;

import java.util.Arrays;

public class LC0217_ContainsDuplicate {

	public static boolean containsDuplicate(int[] nums) {
		Arrays.sort(nums);
		for (int i = 0; i < nums.length - 1; i++) {
			if (nums[i] == nums[i + 1])
				return true;
		}
		return false;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 4, 2, 2 };
		System.out.println(containsDuplicate(nums));
	}
}