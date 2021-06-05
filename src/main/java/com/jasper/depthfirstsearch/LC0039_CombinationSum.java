package com.jasper.depthfirstsearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LC0039_CombinationSum {

	public List<List<Integer>> combinationSum(int[] candidates, int target) {

		List<List<Integer>> res = new ArrayList<List<Integer>>();
		List<Integer> path = new ArrayList<Integer>();

		if (candidates == null || candidates.length == 0)
			return res;

		Arrays.sort(candidates);

		dfs(0, target, res, path, candidates);

		return res;
	}

	public void dfs(int pos, int target, List<List<Integer>> res,
			List<Integer> path, int[] candidates) {

		if (target < 0)
			return;

		if (target == 0) {
			res.add(new ArrayList<Integer>(path));
			return;
		}

		for (int i = pos; i < candidates.length; i++) { // 如果这里是 i=0， 那么 允许降顺
			path.add(candidates[i]);
			// 如果这里是i + 1， 那么这里就不可能有[2,2,3]
			dfs(i, target - candidates[i], res, path, candidates);
			path.remove(path.size() - 1);
		}
	}
}