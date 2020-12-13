package com.jasper.tree;

import com.jasper.common.TreeNode;

public class LC0450_DeleteNodeinaBST {

	public TreeNode deleteNode(TreeNode root, int key) {

		if (root == null) {
			return null;
		}

		if (key < root.val) {
			root.left = deleteNode(root.left, key);
		} else if (key > root.val) {
			root.right = deleteNode(root.right, key);
		} else {
			if (root.left == null) { // one child
				return root.right;
			} else if (root.right == null) { // one child
				return root.left;
			}
			// two children
			// set it as the max of left
			root.val = findMax(root.left).val;
			// delete the max of left
			root.left = deleteNode(root.left, root.val);
		}

		return root;
	}

	private TreeNode findMax(TreeNode node) {
		while (node.right != null) {
			node = node.right;
		}
		return node;
	}

}
