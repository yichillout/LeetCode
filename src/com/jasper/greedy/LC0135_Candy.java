package com.jasper.greedy;

public class LC0135_Candy {

	public int candy(int[] ratings) {
		int length = ratings.length;
		if (length <= 0)
			return 0;
		int[] nums = new int[length];
		nums[0] = 1;
		for (int i = 1; i < nums.length; i++) {
			nums[i] = 1;
			if (ratings[i] > ratings[i - 1])
				nums[i] = nums[i - 1] + 1;
		}
		for (int i = nums.length - 2; i >= 0; i--) {
			if (ratings[i] > ratings[i + 1])
				nums[i] = Math.max(nums[i], nums[i + 1] + 1);
		}
		int count = 0;
		for (int i = 0; i < length; i++)
			count += nums[i];
		return count;
	}

}
