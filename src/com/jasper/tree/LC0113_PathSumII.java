package com.jasper.tree;

import java.util.*;

import com.jasper.common.TreeNode;

public class LC0113_PathSumII {

	public List<List<Integer>> pathSum(TreeNode root, int sum) {

		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (root == null)
			return res;

		List<Integer> temp = new ArrayList<Integer>();
		dfs(root, res, temp, sum);

		return res;
	}

	private void dfs(TreeNode root, List<List<Integer>> res,
			List<Integer> temp, int sum) {

		temp.add(root.val);
		sum = sum - root.val;

		if (sum == 0 && root.left == null && root.right == null) {
			res.add(new ArrayList<Integer>(temp));
		}

		if (root.left != null)
			dfs(root.left, res, temp, sum);
		if (root.right != null)
			dfs(root.right, res, temp, sum);

		temp.remove(temp.size() - 1);
	}
}
