package com.jasper.tree;

import com.jasper.common.TreeNode;

public class LC0563_BinaryTreeTilt {

	public int findTilt(TreeNode root) {
		int[] res = new int[1];
		sum(root, res);
		return res[0];
	}

	private int sum(TreeNode node, int[] res) {
		if (node == null) {
			return 0;
		}

		int left = sum(node.left, res);
		int right = sum(node.right, res);

		res[0] += Math.abs(left - right);

		return left + right + node.val;
	}
}
