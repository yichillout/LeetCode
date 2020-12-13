package com.jasper.tree;

import com.jasper.common.TreeNode;

public class LC0543_DiameterofBinaryTree {

	int result = 0;

	public int diameterOfBinaryTree(TreeNode root) {
		maxDepth(root);
		return result;
	}

	public int maxDepth(TreeNode node) {

		if (node == null)
			return 0;

		int left = maxDepth(node.left);
		int right = maxDepth(node.right);

		if (left + right > result) {
			result = left + right;
		}

		return left > right ? left + 1 : right + 1;

	}

}
