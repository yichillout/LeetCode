package com.jasper.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.jasper.common.TreeNode;

public class LC0145_BinaryTreePostorderTraversal {

	// Solution 1: DFS
	public List<Integer> postorderTraversal1(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		traverse(root, list);
		return list;
	}

	public void traverse(TreeNode node, List<Integer> list) {
		if (node == null)
			return;

		traverse(node.left, list);
		traverse(node.right, list);
		list.add(node.val);
	}

	// Solution 2: 2 Stack
	public List<Integer> postorderTraversal2(TreeNode node) {

		List<Integer> list = new ArrayList<Integer>();
		Stack<TreeNode> stack1 = new Stack<TreeNode>();
		Stack<TreeNode> stack2 = new Stack<TreeNode>();

		if (node == null) {
			return list;
		}

		stack1.push(node);

		while (!stack1.isEmpty()) {
			TreeNode cur = stack1.pop();
			stack2.push(cur);

			if (cur.left != null)
				stack1.push(cur.left);

			if (cur.right != null)
				stack1.push(cur.right);
		}

		while (!stack2.isEmpty()) {
			list.add(stack2.pop().val);
		}

		return list;
	}

	// Solution 3: 1 Stack
	public List<Integer> postorderTraversal3(TreeNode node) {

		List<Integer> list = new ArrayList<Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>();

		if (node == null)
			return list;

		TreeNode h = node;
		TreeNode c = null;

		stack.push(node);

		while (!stack.isEmpty()) {
			c = stack.peek();
			if (c.left != null && c.left != h && c.right != h) {
				stack.push(c.left);
			} else if (c.right != null && c.right != h) {
				stack.push(c.right);
			} else {
				h = stack.pop();
				list.add(h.val);
			}
		}

		return list;
	}
}
