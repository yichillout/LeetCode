package com.jasper.tree;

import com.jasper.common.TreeNode;

public class LC0098_ValidateBinarySearchTree {

	public boolean isValidBST(TreeNode root) {
		return isValidBSTHelper(root, null, null);
	}

	public boolean isValidBSTHelper(TreeNode root, Integer min, Integer max) {

		if (root == null)
			return true;
		if (max != null && root.val >= max) {
			return false;
		}
		if (min != null && root.val <= min) {
			return false;
		}
		return isValidBSTHelper(root.left, min, root.val) && isValidBSTHelper(root.right, root.val, max);
	}
}
