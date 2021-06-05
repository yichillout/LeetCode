package com.jasper.bitmanipulation;

public class LC0268_MissingNumber {

	// Solution 1 : bit manipulation
	public int missingNumber1(int[] nums) {

		int xor = 0, i = 0;
		for (i = 0; i < nums.length; i++) {
			xor = xor ^ i ^ nums[i];
		}

		return xor ^ i;
	}

	// Solution 2
	public int missingNumber2(int[] nums) {
		int len = nums.length;
		int sum = 0;
		for (int i = 0; i < len + 1; i++) {
			sum += i;
		}
		for (int i = 0; i < len; i++)
			sum -= nums[i];
		return sum;
	}
}
