package com.jasper.tree;

import java.util.*;

import com.jasper.common.TreeNode;

public class LC0513_FindBottomLeftTreeValue {

	// Right-to-Left BFS
	public int findBottomLeftValue(TreeNode root) {

		Queue<TreeNode> q = new LinkedList<TreeNode>();
		TreeNode result = null;

		q.offer(root);

		while (!q.isEmpty()) {
			TreeNode temp = q.poll();
			if (temp.right != null) {
				q.offer(temp.right);
			}
			if (temp.left != null) {
				q.offer(temp.left);
			}
			result = temp;
		}

		return result.val;
	}
}
