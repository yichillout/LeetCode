package com.jasper.bitmanipulation;

import java.util.*;

public class LC0169_MajorityElement {

	// Solution 1 : bit manipulation
	public int majorityElement1(int[] nums) {

		int[] bit = new int[32];
		for (int num : nums) {
			for (int i = 0; i < 32; i++) {
				if ((num >> (31 - i) & 1) == 1)
					bit[i]++;
			}
		}

		int result = 0;
		for (int i = 0; i < 32; i++) {
			if (bit[i] > nums.length / 2) {
				bit[i] = 1;
			} else {
				bit[i] = 0;
			}

			result += bit[i] * (1 << (31 - i));
		}

		return result;
	}

	// Solution 2 : voting algorithm
	public int majorityElement2(int[] nums) {
		
		int result = 0, count = 0;

		for (int i = 0; i < nums.length; i++) {
			if (count == 0) {
				result = nums[i];
				count = 1;
			} else if (result == nums[i]) {
				count++;
			} else {
				count--;
			}
		}

		return result;
	}

	// Solution 3 : Sorting
	public int majorityElement3(int[] nums) {

		Arrays.sort(nums);
		return nums[nums.length / 2];

	}

	// Solution 4 : Hashtable
	public int majorityElement4(int[] nums) {

		Map<Integer, Integer> myMap = new HashMap<Integer, Integer>();
		int result = 0;
		for (int num : nums) {
			if (!myMap.containsKey(num)) {
				myMap.put(num, 1);
			} else {
				myMap.put(num, myMap.get(num) + 1);
			}

			if (myMap.get(num) > nums.length / 2) {
				result = num;
				break;
			}
		}

		return result;
	}
}
