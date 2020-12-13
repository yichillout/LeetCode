package com.jasper.tree;

import com.jasper.common.TreeNode;

public class LC0104_MaximumDepthofBinaryTree {

	public int maxDepth(TreeNode root) {

		if (root == null)
			return 0;

		int left = maxDepth(root.left);
		
		int right = maxDepth(root.right);

		return 1 + Math.max(left, right);
	}

}
