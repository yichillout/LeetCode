package com.jasper.tree;

import com.jasper.common.TreeNode;

public class LC0236_LowestCommonAncestorofaBinaryTree {

	public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

		if (root == null)
			return null;

		if (root == p || root == q)
			return root;

		TreeNode left = lowestCommonAncestor(root.left, p, q);
		TreeNode right = lowestCommonAncestor(root.right, p, q);

		if (left != null && right != null)
			return root;
		else
			return left != null ? left : right;
	}

}
