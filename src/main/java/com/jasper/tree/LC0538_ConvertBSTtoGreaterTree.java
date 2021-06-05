package com.jasper.tree;

import com.jasper.common.TreeNode;

public class LC0538_ConvertBSTtoGreaterTree {

	int sum = 0;

	// Right-root-left
	public TreeNode convertBST(TreeNode root) {
		traverse(root);
		return root;
	}

	public void traverse(TreeNode node) {
		if (node == null)
			return;

		traverse(node.right);
		node.val = node.val + sum;
		sum = node.val;
		traverse(node.left);
	}

}
