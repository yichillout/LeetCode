package com.jasper.bitmanipulation;

public class LC0260_SingleNumberIII {

	public int[] singleNumber(int[] nums) {

		int xorSum = 0;

		for (int i = 0; i < nums.length; i++) {
			xorSum ^= nums[i];
		}

		int bitFlag = xorSum & (~(xorSum - 1));
		int[] result = new int[2];

		for (int i = 0; i < nums.length; i++) {

			if ((bitFlag & nums[i]) == 0) {
				result[0] ^= nums[i];
			}

			if ((bitFlag & nums[i]) != 0) {
				result[1] ^= nums[i];
			}

		}

		return result;
	}
}
