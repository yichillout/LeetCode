package com.jasper.tree;

import java.util.*;

import com.jasper.common.TreeNode;

public class LC0094_BinaryTreeInorderTraversal {

	// Solution 1: Recursion
	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> result = new ArrayList<Integer>();
		traverse(root, result);
		return result;
	}

	public void traverse(TreeNode node, List<Integer> result) {
		if (node == null)
			return;
		traverse(node.left, result);
		result.add(node.val);
		traverse(node.right, result);
	}

	// Solution 2: Iterative
	public List<Integer> inorderTraversal2(TreeNode root) {

		List<Integer> list = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();

		TreeNode cur = root;

		while (cur != null) {
			stack.push(cur);
			cur = cur.left;
		}

		while (!stack.isEmpty()) {
			cur = stack.pop();
			list.add(cur.val);

			if (cur.right != null) {
				cur = cur.right;
				while (cur != null) {
					stack.push(cur);
					cur = cur.left;
				}
			}
		}
		return list;
	}

	// Solution 3: Morris
	public List<Integer> inorderTraversal3(TreeNode root) {

		List<Integer> list = new ArrayList<Integer>();

		if (root == null)
			return list;

		return list;

	}
}