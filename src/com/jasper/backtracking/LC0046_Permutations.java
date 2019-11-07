package com.jasper.backtracking;

import java.util.ArrayList;
import java.util.List;

public class LC0046_Permutations {

	boolean[] used;

	public List<List<Integer>> permute(int[] nums) {

		List<List<Integer>> res = new ArrayList<List<Integer>>();
		List<Integer> temp = new ArrayList<Integer>();
		used = new boolean[nums.length];

		permuteHelper(nums, res, temp);

		return res;
	}

	private void permuteHelper(int[] nums, List<List<Integer>> res, List<Integer> temp) {

		if (nums.length == temp.size()) {
			res.add(new ArrayList<Integer>(temp));
			return;
		}

		for (int i = 0; i < nums.length; i++) {
			if (!used[i]) {
				used[i] = true;
				temp.add(nums[i]);
				permuteHelper(nums, res, temp);
				temp.remove(temp.size() - 1);
				used[i] = false;
			}
		}
	}
}
