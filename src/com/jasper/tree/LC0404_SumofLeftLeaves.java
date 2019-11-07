package com.jasper.tree;

import com.jasper.common.TreeNode;

public class LC0404_SumofLeftLeaves {

	public int sumOfLeftLeaves(TreeNode root) {
		return dfs(root, false);
	}

	public int dfs(TreeNode node, boolean isLeft) {

		if (node == null)
			return 0;

		if (node.left == null && node.right == null && isLeft == true)
			return node.val;

		return dfs(node.left, true) + dfs(node.right, false);
	}
}
