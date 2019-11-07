package com.jasper.array;

import java.util.*;

public class LC0128_LongestConsecutiveSequence {

	public int longestConsecutive(int[] nums) {

		if (nums == null || nums.length == 0)
			return 0;

		Set<Integer> set = new HashSet<Integer>();

		for (int i = 0; i < nums.length; i++) {
			set.add(nums[i]);
		}

		int max = 0;

		for (int i = 0; i < nums.length; i++) {

			if (set.contains(nums[i])) {
				set.remove(nums[i]);
				int left = nums[i] - 1;
				int right = nums[i] + 1;
				int localMax = 1;

				while (set.contains(left)) {
					set.remove(left);
					localMax++;
					left--;
				}

				while (set.contains(right)) {
					set.remove(right);
					localMax++;
					right++;
				}

				max = Math.max(max, localMax);
			}
		}

		return max;

	}
}
