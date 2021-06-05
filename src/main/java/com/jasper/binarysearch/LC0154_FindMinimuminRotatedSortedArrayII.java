package com.jasper.binarysearch;

public class LC0154_FindMinimuminRotatedSortedArrayII {

	public static int findMin(int[] nums) {
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
		return nums[lo];
	}

	public static void main(String[] args) {
		int[] nums = { 11, 13, 14, 2, 2, 3, 3, 3, 5, 6, 7, 8, 9 };
		System.out.println(findMin(nums));
	}

}
