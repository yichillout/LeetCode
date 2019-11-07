package com.jasper.depthfirstsearch;

import com.jasper.common.TreeNode;

public class LC0098_ValidateBinarySearchTree {
	public static boolean isValidBST(TreeNode root) {
		return isValidBST(root, null, null);
	}

	private static boolean isValidBST(TreeNode root, Integer max, Integer min) {
		if (root == null) {
			return true;
		}
		// If the value of the node greater than the max, return false.
		if (max != null && root.val >= max) {
			return false;
		}
		// If the value of the node less than the min, return false.
		if (min != null && root.val <= min) {
			return false;
		}
		// recursion
		return isValidBST(root.left, root.val, min) && isValidBST(root.right, max, root.val);
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(50);
		root.left = new TreeNode(25);
		root.right = new TreeNode(100);
		root.left.left = new TreeNode(10);
		System.out.println(isValidBST(root));
		
		TreeNode root1 = new TreeNode(50);
		root1.left = new TreeNode(25);
		root1.right = new TreeNode(100);
		root1.left.left = new TreeNode(27);
		System.out.println(isValidBST(root1));
	}
}
