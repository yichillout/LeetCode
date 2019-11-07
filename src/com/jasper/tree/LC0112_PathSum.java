package com.jasper.tree;

import com.jasper.common.TreeNode;

public class LC0112_PathSum {

	public boolean hasPathSum(TreeNode root, int sum) {

		if (root == null)
			return false;

		int remainingSum = sum - root.val;

		if (remainingSum == 0 && root.left == null && root.right == null)
			return true;

		boolean left = hasPathSum(root.left, remainingSum);
		boolean right = hasPathSum(root.right, remainingSum);

		return left || right;
	}
}
