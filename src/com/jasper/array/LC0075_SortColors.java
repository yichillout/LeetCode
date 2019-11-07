package com.jasper.array;

//using counting sort
public class LC0075_SortColors {

	// Solution 1 : Counting Sort : space is O(n)
	public static void sortColors1(int[] nums) {

		if (nums == null || nums.length == 0)
			return;

		int[] colorCount = new int[3];
		int[] result = new int[nums.length];

		for (int i = 0; i < nums.length; i++) {
			colorCount[nums[i]]++;
		}

		for (int i = 1; i < 3; i++) {
			colorCount[i] = colorCount[i] + colorCount[i - 1];
		}

		for (int i = 0; i < nums.length; i++) {
			result[colorCount[nums[i]] - 1] = nums[i];
			colorCount[nums[i]]--;
		}

		for (int i = 0; i < nums.length; i++) {
			nums[i] = result[i];
		}

	}

	// Solution 2 : Improved Counting Sort : space is O(1)
	public static void sortColors2(int[] nums) {
		if (nums == null || nums.length < 2) {
			return;
		}

		int[] countArray = new int[3];
		for (int i = 0; i < nums.length; i++) {
			countArray[nums[i]]++;
		}

		int j = 0;
		int k = 0;
		while (j <= 2) {
			if (countArray[j] != 0) {
				nums[k++] = j;
				countArray[j]--;
			} else {
				j++;
			}
		}
	}

	public static void main(String[] args) {

		int[] nums = { 0, 1, 1, 2, 0, 2, 1, 1, 0 };
		sortColors1(nums);

	}
}
