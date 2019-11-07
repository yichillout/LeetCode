package com.jasper.binarysearch;

public class LC0034_SearchforaRange {

	public int[] searchRange(int[] nums, int target) {

		if (nums == null || nums.length == 0)
			return new int[] { -1, -1 };

		int start = 0;
		int end = nums.length - 1;

		while (start + 1 < end) {
			int mid = start + (end - start) / 2;
			if (nums[mid] == target) {
				end = mid;
			} else if (nums[mid] > target) {
				end = mid;
			} else {
				start = mid;
			}
		}

		int index1 = -1;

		if (nums[start] == target) {
			index1 = start;
		} else if (nums[end] == target) {
			index1 = end;
		}

		if (index1 == -1) {
			return new int[] { -1, -1 };
		}

		int index2 = index1;

		for (int i = index1; i < nums.length; i++) {
			if (nums[index1] == nums[i]) {
				index2 = i;
			}
		}

		return new int[] { index1, index2 };

	}
}
