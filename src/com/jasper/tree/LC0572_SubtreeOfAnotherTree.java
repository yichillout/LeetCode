package com.jasper.tree;

import com.jasper.common.TreeNode;

public class LC0572_SubtreeOfAnotherTree {

	public boolean isSubtree(TreeNode s, TreeNode t) {

		if (s == null)
			return false;

		if (isSameTree(s, t)) {
			return true;
		}

		boolean left = isSubtree(s.left, t);
		boolean right = isSubtree(s.right, t);

		return left || right;
	}

	public boolean isSameTree(TreeNode p, TreeNode q) {

		if (p == null && q == null)
			return true;

		if (p == null || q == null) {
			return false;
		}

		if (p.val != q.val) {
			return false;
		}

		return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
	}

}
