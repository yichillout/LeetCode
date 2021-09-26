package com.jasper.tree;

import java.util.*;

import com.jasper.common.TreeNode;

public class LC0199_BinaryTreeRightSideView {

	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		traverse(root, result, 0);
		return result;
	}

	public void traverse(TreeNode node, List<Integer> result, int level) {

		if (node == null)
			return;

		if (result.size() == level) {
			result.add(node.val);
		}

		traverse(node.right, result, level + 1);
		traverse(node.left, result, level + 1);
	}
}
