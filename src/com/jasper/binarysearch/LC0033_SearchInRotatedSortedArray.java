package com.jasper.binarysearch;

public class LC0033_SearchInRotatedSortedArray {

	public static int search(int[] nums, int target) {

		if (nums == null || nums.length == 0)
			return -1;

		int lo = 0;
		int hi = nums.length - 1;
		int mid = 0;

		while (lo < hi) {
			mid = lo + (hi - lo) / 2;
			if (nums[mid] < nums[hi]) {
				hi = mid;
			} else {
				lo = mid + 1;
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
			return -1;

		return lo;
	}

	public static void main(String[] args) {
		// int[] nums = { 3, 1 };
		// int[] nums = { 6, 7, 0, 1, 2, 4, 5 };
		int[] nums = { 3, 5, 1 };
		System.out.println(search(nums, 5));

	}
}
