package com.jasper.tree;

import java.util.*;

public class LC0117_PopulatingNextRightPointersinEachNodeII {

	public TreeLinkNode connect(TreeLinkNode root) {

		Queue<TreeLinkNode> queue = new LinkedList<TreeLinkNode>();

		if (root == null)
			return root;

		TreeLinkNode pre = null;
		root.next = null;

		queue.add(root);

		while (!queue.isEmpty()) {
			int count = queue.size(); // num of node in one level
			for (int i = 0; i < count; i++) {
				TreeLinkNode tempTreeNode = queue.poll();

				if (i == 0) {
					tempTreeNode.next = null;
				} else {
					tempTreeNode.next = pre;
				}

				pre = tempTreeNode;

				if (tempTreeNode.right != null) {
					queue.add(tempTreeNode.right);
				}
				if (tempTreeNode.left != null) {
					queue.add(tempTreeNode.left);
				}
			}
		}

		return root;
	}

	public TreeLinkNode connect1(TreeLinkNode root) {

		TreeLinkNode cur = root;
		TreeLinkNode head = null;
		TreeLinkNode prev = null;

		while (cur != null) {
			while (cur != null) {
				if (cur.left != null) {
					if (prev != null) {
						prev.next = cur.left;
					} else {
						head = cur.left;
					}
					prev = cur.left;
				}

				if (cur.right != null) {
					if (prev != null) {
						prev.next = cur.right;
					} else {
						head = cur.right;
					}
					prev = cur.right;
				}
				cur = cur.next;
			}

			cur = head;
			head = null;
			prev = null;
		}

		return root;
	}

	public static void main(String[] args) {

	}

}
