package com.jasper.hashtable;

import java.util.*;

public class LC0001_TwoSum {
	public int[] twoSum(int[] nums, int target) {

		Map<Integer, Integer> hm = new HashMap<Integer, Integer>();
		int[] res = new int[2];

		for (int i = 0; i < nums.length; i++) {
			int temp = target - nums[i];
			if (hm.containsKey(temp)) {
				res[0] = i;
				res[1] = hm.get(temp);
			} else {
				hm.put(nums[i], i);
			}
		}
		return res;
	}
}
