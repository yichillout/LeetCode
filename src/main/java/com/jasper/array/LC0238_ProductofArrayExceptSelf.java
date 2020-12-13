package com.jasper.array;

public class LC0238_ProductofArrayExceptSelf {

	// Solution 1 : 超时
	public int[] productExceptSelf1(int[] nums) {

		int[] result = new int[nums.length];
		int count = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 0) {
				count++;
			}
		}

		if (count >= 2) {
			return result;
		}

		int mul = 1;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != 0) {
				mul *= nums[i];
			}
		}

		if (count == 1) {
			for (int i = 0; i < nums.length; i++) {
				if (nums[i] == 0) {
					result[i] = mul;
				}
			}
			return result;
		}

		for (int i = 0; i < nums.length; i++) {
			result[i] = mul / nums[i];
		}

		return result;
	}

	// Solution 2
	public int[] productExceptSelf2(int[] nums) {
		int n = nums.length;
		int[] res = new int[n];
		res[0] = 1;
		for (int i = 1; i < n; i++) {
			res[i] = res[i - 1] * nums[i - 1];
		}
		int right = 1;
		for (int i = n - 1; i >= 0; i--) {
			res[i] *= right;
			right *= nums[i];
		}
		return res;
	}
}
