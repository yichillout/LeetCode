package com.jasper.depthfirstsearch;

import com.jasper.common.TreeNode;

public class LC0124_BinaryTreeMaximumPathSum {

	static int max = Integer.MIN_VALUE;

	public static int maxPathSum(TreeNode root) {
		helper(root);
		return max;
	}

	private static int helper(TreeNode root) {

		if (root == null)
			return 0;

		// if left or right is less than 0 just ignore it
		int left = Math.max(helper(root.left), 0);
		int right = Math.max(helper(root.right), 0);

		max = Math.max(max, root.val + left + right);

		return root.val + Math.max(left, right);
	}

	public static void main(String[] args) {

		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);

		System.out.println(maxPathSum(root));

	}
}
