package com.jasper.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC0018_4Sum {

	public List<List<Integer>> fourSum(int[] nums, int target) {

		List<List<Integer>> result = new ArrayList<List<Integer>>();
		Arrays.sort(nums);

		for (int i = 0; i < nums.length - 3; i++) {
			if (i != 0 && nums[i] == nums[i - 1])
				continue;
			for (int j = i + 1; j < nums.length - 2; j++) {
				if (j != i + 1 && nums[j] == nums[j - 1])
					continue;
				int left = j + 1;
				int right = nums.length - 1;
				while (right > left) {
					int sum = nums[i] + nums[j] + nums[left] + nums[right];
					if (sum == target) {
						ArrayList<Integer> temp = new ArrayList<Integer>();
						temp.add(nums[i]);
						temp.add(nums[j]);
						temp.add(nums[left]);
						temp.add(nums[right]);
						result.add(temp);
						while (left < right && nums[left] == nums[left + 1])
							left++;
						while (left < right && nums[right] == nums[right - 1])
							right--;
					}
					if (sum <= target)
						left++;
					if (sum >= target)
						right--;
				}
			}
		}
		return result;
	}
}