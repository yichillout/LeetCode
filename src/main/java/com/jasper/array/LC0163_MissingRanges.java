package com.jasper.array;

import java.util.ArrayList;
import java.util.List;

public class LC0163_MissingRanges {

	public static List<String> findMissingRanges(int[] nums, int lower, int upper) {

		List<String> result = new ArrayList<String>();
		int pre = lower - 1;
		for (int i = 0; i <= nums.length; i++) {
			int after;

			if (i == nums.length) {
				after = upper + 1;
			} else {
				after = nums[i];
			}

			if (pre + 2 == after) {
				result.add(String.valueOf(pre + 1));
			} else if (pre + 2 < after) {
				result.add(String.valueOf(pre + 1) + "->" + String.valueOf(after - 1));
			}

			pre = after;
		}

		return result;
	}

	public static void main(String[] args) {
		int[] nums = { 0, 1, 3, 50, 75 };
		System.out.println(findMissingRanges(nums, 0, 99));
	}

}
