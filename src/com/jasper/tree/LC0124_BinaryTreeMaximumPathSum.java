package com.jasper.tree;

import com.jasper.common.TreeNode;

public class LC0124_BinaryTreeMaximumPathSum {

	// Solution 1 : traversal
	static int max = Integer.MIN_VALUE;

	public static int maxPathSum1(TreeNode root) {
		helper1(root);
		return max;
	}

	private static int helper1(TreeNode root) {

		if (root == null)
			return 0;

		// if left or right is less than 0 just ignore it
		int left = Math.max(helper1(root.left), 0);
		int right = Math.max(helper1(root.right), 0);

		max = Math.max(max, root.val + left + right);

		// when return, we can just use only left or right
		return root.val + Math.max(left, right);
	}

	// Solution 2 : divide and conquer
	class ResultType {
		int maxInSubTree;
		int maxFromNodeOnePath;

		public ResultType(int maxInSubTree, int maxFromNodeOnePath) {
			this.maxInSubTree = maxInSubTree;
			this.maxFromNodeOnePath = maxFromNodeOnePath;
		}
	}

	public int maxPathSum2(TreeNode root) {
		return helper(root).maxInSubTree;
	}

	private ResultType helper(TreeNode node) {
		if (node == null)
			return new ResultType(Integer.MIN_VALUE, 0);

		ResultType left = helper(node.left);
		ResultType right = helper(node.right);

		int maxFromNodeOnePath = Math.max(left.maxFromNodeOnePath, right.maxFromNodeOnePath) + node.val;
		maxFromNodeOnePath = Math.max(maxFromNodeOnePath, node.val);

		int maxInSubTree = node.val + Math.max(left.maxFromNodeOnePath, 0) + Math.max(right.maxFromNodeOnePath, 0);
		maxInSubTree = Math.max(maxInSubTree, Math.max(left.maxInSubTree, right.maxInSubTree));

		return new ResultType(maxInSubTree, maxFromNodeOnePath);

	}

	public static void main(String[] args) {

		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);

		System.out.println(maxPathSum1(root));

	}
}
