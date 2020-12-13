package com.jasper.tree;

import com.jasper.common.TreeNode;

public class LC0129_SumRoottoLeafNumbers {

	public int sumNumbers(TreeNode root) {
		return sumNumbers(root, 0);
	}

	public int sumNumbers(TreeNode node, int sum) {

		if (node == null)
			return 0;

		sum = sum * 10 + node.val;

		if (node.left == null && node.right == null)
			return sum;

		return sumNumbers(node.left, sum) + sumNumbers(node.right, sum);

	}
}
