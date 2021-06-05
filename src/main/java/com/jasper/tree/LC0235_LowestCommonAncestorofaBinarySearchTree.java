package com.jasper.tree;

import com.jasper.common.TreeNode;

public class LC0235_LowestCommonAncestorofaBinarySearchTree {

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

		if (p == null || q == null)
			throw new IllegalArgumentException("p or q can not be null.");

		if (root == null)
			return null;

		if (p.val < root.val && q.val < root.val)
			return lowestCommonAncestor(root.left, p, q);
		if (p.val > root.val && q.val > root.val)
			return lowestCommonAncestor(root.right, p, q);

		assert p.val == root.val || q.val == root.val || (root.val - p.val) * (root.val - q.val) < 0;

		return root;
	}

}
