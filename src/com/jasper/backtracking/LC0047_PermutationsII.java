package com.jasper.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC0047_PermutationsII {

	public List<List<Integer>> permuteUnique(int[] nums) {
		List<List<Integer>> list = new ArrayList<>();
		List<Integer> tmp = new ArrayList<>();
		boolean[] used = new boolean[nums.length];
		Arrays.sort(nums);
		dfs(list, used, nums, tmp);
		return list;
	}

	public void dfs(List<List<Integer>> list, boolean[] used, int[] nums, List<Integer> tmp) {
		if (tmp.size() == nums.length) {
			list.add(new ArrayList(tmp));
			return;
		}

		for (int i = 0; i < nums.length; i++) {
			if (used[i])
				continue;
			if (i > 0 && nums[i - 1] == nums[i] && !used[i - 1])
				continue;
			tmp.add(nums[i]);
			used[i] = true;
			dfs(list, used, nums, tmp);
			tmp.remove(tmp.size() - 1);
			used[i] = false;
		}

	}

}
