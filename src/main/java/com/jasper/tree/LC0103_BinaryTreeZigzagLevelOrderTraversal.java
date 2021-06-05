package com.jasper.tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.jasper.common.TreeNode;

public class LC0103_BinaryTreeZigzagLevelOrderTraversal {
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

		List<List<Integer>> result = new ArrayList<List<Integer>>();
		Deque<TreeNode> dq = new LinkedList<TreeNode>();

		if (root == null)
			return result;

		dq.addLast(root);
		int level = 0;

		while (!dq.isEmpty()) {
			List<Integer> arryList = new ArrayList<Integer>();
			int count = dq.size();
			if (level % 2 == 1) {
				for (int i = 0; i < count; i++) {
					TreeNode tempTreeNode = dq.pollFirst();
					if (tempTreeNode.right != null) {
						dq.addLast(tempTreeNode.right);
					}
					if (tempTreeNode.left != null) {
						dq.addLast(tempTreeNode.left);
					}
					arryList.add(tempTreeNode.val);
				}
			} else {
				for (int i = 0; i < count; i++) {
					TreeNode tempTreeNode = dq.pollLast();
					if (tempTreeNode.left != null) {
						dq.addFirst(tempTreeNode.left);
					}
					if (tempTreeNode.right != null) {
						dq.addFirst(tempTreeNode.right);
					}
					arryList.add(tempTreeNode.val);
				}
			}

			result.add(arryList);
			level++;
		}
		return result;
	}
}
