package com.jasper.binarysearch;

public class LC0081_SearchInRotatedSortedArrayII {

	public static boolean search(int[] nums, int target) {

		if (nums == null || nums.length == 0)
			return false;

		int lo = 0;
		int hi = nums.length - 1;
		int mid = 0;

		while (lo < hi) {
			mid = lo + (hi - lo) / 2;
			if (nums[mid] < nums[hi]) {
				hi = mid;
			} else if (nums[mid] > nums[hi]) {
				lo = mid + 1;
			} else {
				hi--;
			}
		}

		if (lo == 0) {
			hi = nums.length - 1;
		} else if (target >= nums[0]) {
			hi = lo - 1;
			lo = 0;
		} else {
			hi = nums.length - 1;
		}

		while (lo < hi) {
			mid = (lo + hi) / 2;
			if (nums[mid] >= target) {
				hi = mid;
			} else {
				lo = mid + 1;
			}
		}

		if (nums[lo] != target)
			return false;

		return true;
	}

	public static void main(String[] args) {

		// int[] nums = { 11, 13, 14, 2, 3, 5, 6, 7, 8, 9 };
		int[] nums = { 1, 1, 3, 1, 1, 2 };
		System.out.println(search(nums, 3));

	}
}
