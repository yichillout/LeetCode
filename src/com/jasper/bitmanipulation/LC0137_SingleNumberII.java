package com.jasper.bitmanipulation;

public class LC0137_SingleNumberII {

	public int singleNumber(int[] nums) {
		int one = 0;
		int two = 0;
		int three = 0;

		for (int i = 0; i < nums.length; i++) {
			two = two | (one & nums[i]);
			one = one ^ nums[i];
			three = one & two;
			one = one & (~three);
			two = two & (~three);
		}
		return one;
	}

}
