package com.jasper.tree;

import com.jasper.common.TreeNode;

public class LC0979_DistributeCoinsInBinaryTree {

	int res = 0;

	public int distributeCoins(TreeNode root) {
		dfs(root);
		return res;
	}

	private int dfs(TreeNode node) {
		if (node == null)
			return 0;

		int left = dfs(node.left);
		int right = dfs(node.right);

		res += Math.abs(left) + Math.abs(right);

		return node.val + left + right - 1;
	}
}
