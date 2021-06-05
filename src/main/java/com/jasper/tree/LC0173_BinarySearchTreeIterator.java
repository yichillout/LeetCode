package com.jasper.tree;

import java.util.*;

import com.jasper.common.TreeNode;

class BSTIterator {

	Stack<TreeNode> stack;

	public BSTIterator(TreeNode root) {
		stack = new Stack<TreeNode>();
		TreeNode cur = root;
		while (cur != null) {
			stack.push(cur);
			cur = cur.left;
		}
	}

	/** @return the next smallest number */
	public int next() {
		TreeNode node = stack.pop();
		TreeNode cur = node;
		if (cur.right != null) {
			cur = cur.right;
			while (cur != null) {
				stack.push(cur);
				cur = cur.left;
			}
		}
		return node.val;
	}

	/** @return whether we have a next smallest number */
	public boolean hasNext() {
		return !stack.isEmpty();
	}
}

public class LC0173_BinarySearchTreeIterator {

}
