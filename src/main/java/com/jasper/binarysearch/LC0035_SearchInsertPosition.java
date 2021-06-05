package com.jasper.binarysearch;

public class LC0035_SearchInsertPosition {

	public static int searchInsert(int[] nums, int target) {

		int lo = 0;
		int hi = nums.length - 1;

		while (lo < hi) {
			int mid = lo + (hi - lo) / 2;
			if (target <= nums[mid]) {
				hi = mid;
			} else {
				lo = mid + 1;
			}
		}

		return nums[lo] >= target ? lo : lo + 1;
	}

	// important !!!!!
	public static boolean binarySearch(int[] nums, int target) {

		int lo = 0;
		int hi = nums.length - 1;

		while (lo < hi) {
			int mid = lo + (hi - lo) / 2;
			if (target <= nums[mid]) {
				hi = mid;
			} else {
				lo = mid + 1;
			}
		}

		return nums[lo] == target;
	}

	public static void main(String[] args) {

		int[] nums = { 1, 3, 5, 6 };
		int target = 7;
		//System.out.println(binarySearch(nums, target));
		System.out.println(searchInsert(nums, target));

	}

}
