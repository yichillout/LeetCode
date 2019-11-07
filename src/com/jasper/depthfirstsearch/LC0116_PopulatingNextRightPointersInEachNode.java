package com.jasper.depthfirstsearch;

import com.jasper.common.TreeLinkNode;

/*
 * Because we assume that it is a perfect binary tree, just populate directly.
 */
public class LC0116_PopulatingNextRightPointersInEachNode {

	public static void connect1(TreeLinkNode root) {

		if (root == null)
			return;

		if (root.left != null) {
			root.left.next = root.right;
		}

		if (root.next != null && root.right != null) {
			root.right.next = root.next.left;
		}

		connect1(root.left);
		connect1(root.right);
	}
}