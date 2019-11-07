package com.jasper.tree;

import java.util.LinkedList;
import java.util.Queue;

import com.jasper.common.TreeNode;

public class LC0623_AddOneRowToTree {
	
	public TreeNode addOneRow(TreeNode root, int v, int d) {

		if (d == 1) {
			TreeNode node = new TreeNode(v);
			node.left = root;
			return node;
		}

		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		for (int i = 0; i < d - 2; i++) {
			int size = queue.size();
			for (int j = 0; j < size; j++) {
				TreeNode temp = queue.poll();
				if (temp.left != null) {
					queue.add(temp.left);
				}
				if (temp.right != null) {
					queue.add(temp.right);
				}
			}
		}

		while (!queue.isEmpty()) {
			TreeNode pre = queue.poll();

			TreeNode tempLeft = pre.left;
			pre.left = new TreeNode(v);
			pre.left.left = tempLeft;

			TreeNode tempRight = pre.right;
			pre.right = new TreeNode(v);
			pre.right.right = tempRight;
		}

		return root;
	}
}
