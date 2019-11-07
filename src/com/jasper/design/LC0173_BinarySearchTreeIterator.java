package com.jasper.design;

import java.util.*;

import com.jasper.common.TreeNode;

// Solution 1: using list : time O(1) space O(n)
class BSTIterator1 {

	List<Integer> list;

	public BSTIterator1(TreeNode root) {
		list = new ArrayList<Integer>();
		traverse(root, list);
	}

	public boolean hasNext() {
		if (list.size() == 0) {
			return false;
		} else {
			return true;
		}
	}

	public int next() {
		int result = -1;
		if (list.size() != 0) {
			result = list.get(0);
			list.remove(0);
		}
		return result;
	}

	public void traverse(TreeNode node, List<Integer> list) {
		if (node == null)
			return;

		traverse(node.left, list);
		list.add(node.val);
		traverse(node.right, list);
	}
}

// Solution 2: using stack : time O(1) space O(h)
class BSTIterator2 {

	private Stack<TreeNode> stack;

	public BSTIterator2(TreeNode root) {
		stack = new Stack<TreeNode>();
		TreeNode cur = root;
		while (cur != null) {
			stack.push(cur);
			if (cur.left != null)
				cur = cur.left;
			else
				break;
		}
	}

	public boolean hasNext() {
		return !stack.isEmpty();
	}

	public int next() {
		TreeNode node = stack.pop();
		TreeNode cur = node;
		// traversal right branch
		if (cur.right != null) {
			cur = cur.right;
			while (cur != null) {
				stack.push(cur);
				if (cur.left != null)
					cur = cur.left;
				else
					break;
			}
		}
		return node.val;
	}
}

public class LC0173_BinarySearchTreeIterator {

}
