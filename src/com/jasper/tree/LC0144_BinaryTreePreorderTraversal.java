package com.jasper.tree;

import java.util.*;

import com.jasper.common.TreeNode;

public class LC0144_BinaryTreePreorderTraversal {

	// Solution 1
	public List<Integer> preorderTraversal1(TreeNode root) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		traverse(root, result);
		return result;
	}

	private void traverse(TreeNode root, ArrayList<Integer> result) {
		if (root == null)
			return;

		result.add(root.val);
		traverse(root.left, result);
		traverse(root.right, result);
	}

	// Solution 2 : stack
	public List<Integer> preorderTraversal2(TreeNode node) {

		List<Integer> list = new ArrayList<Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>();

		if (node == null)
			return list;

		stack.push(node);
		while (!stack.isEmpty()) {
			TreeNode cur = stack.pop();
			list.add(cur.val);

			if (cur.right != null)
				stack.push(cur.right);

			if (cur.left != null)
				stack.push(cur.left);
		}

		return list;
	}

}
