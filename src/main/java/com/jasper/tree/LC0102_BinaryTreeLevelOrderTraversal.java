package com.jasper.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.jasper.common.TreeNode;

public class LC0102_BinaryTreeLevelOrderTraversal {
	
	public List<List<Integer>> levelOrder(TreeNode root) {

		List<List<Integer>> result = new ArrayList<List<Integer>>();
		Queue<TreeNode> queue = new LinkedList<TreeNode>();

		if (root == null)
			return result;

		queue.add(root);

		while (!queue.isEmpty()) {
			List<Integer> arryList = new ArrayList<Integer>();
			int count = queue.size();
			for (int i = 0; i < count; i++) {

				TreeNode tempTreeNode = queue.poll();
				if (tempTreeNode.left != null) {
					queue.add(tempTreeNode.left);
				}
				if (tempTreeNode.right != null) {
					queue.add(tempTreeNode.right);
				}
				arryList.add(tempTreeNode.val);
			}
			result.add(arryList);
		}

		return result;
	}
}
