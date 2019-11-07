package com.jasper.binarysearch;

/*
 origin :      0 1 2 4 5 6 7
 situation 1 : 6 7 0 1 2 4 5   
 situation 2 : 2 4 5 6 7 0 1  
 */

public class LC0153_FindMinimumInRotatedSortedArray {
	
	public static int findMin(int[] nums) {
		
		if (nums == null || nums.length == 0)
			return 0;

		if (nums.length == 1)
			return nums[0];

		int lo = 0;
		int hi = nums.length - 1;

		while (lo < hi) {
			int mid = lo + (hi - lo) / 2;
			if (nums[mid] < nums[hi]) {
				hi = mid;
			} else {
				lo = mid + 1;
			}
		}
		return nums[lo];
	}

	public static void main(String[] args) {

		// int[] nums = { 11, 13, 14, 2, 3, 5, 6, 7, 8, 9 };
		int[] nums = { 6, 7, 0, 1, 2, 4, 5 };
		System.out.println(findMin(nums));

	}
}
