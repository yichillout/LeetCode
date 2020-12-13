package com.jasper.tree;

// 226. Invert Binary Tree
// https://leetcode.com/problems/invert-binary-tree/description/
public class LC0226_InvertBinaryTree {

	// Definition for a binary tree node.
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	// 时间复杂度: O(n), n为树中节点个数
	// 空间复杂度: O(h), h为树的高度
	public TreeNode invertTree(TreeNode root) {

		if (root == null)
			return null;

		TreeNode left = invertTree(root.left);
		TreeNode right = invertTree(root.right);

		root.left = right;
		root.right = left;

		return root;
	}
}
