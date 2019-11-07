package com.jasper.tree;

import java.util.*;

import com.jasper.common.TreeNode;

public class LC0107_BinaryTreeLevelOrderTraversalII {

	// Solution 1 : BFS
	public List<List<Integer>> levelOrderBottom1(TreeNode root) {
		List<List<Integer>> bfs = new ArrayList<List<Integer>>();
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		if (root == null) {
			return bfs;
		}
		queue.add(root);
		while (!queue.isEmpty()) {
			ArrayList<Integer> level = new ArrayList<Integer>();
			int size = queue.size();

			for (int i = 0; i < size; i++) {
				TreeNode head = queue.poll();
				level.add(head.val);
				if (head.left != null) {
					queue.add(head.left);
				}
				if (head.right != null) {
					queue.add(head.right);
				}
			}
			bfs.add(0, level);
		}
		return bfs;
	}

	// Solution 2 : DFS
	public List<List<Integer>> levelOrderBottom2(TreeNode root) {
		List<List<Integer>> wrapList = new LinkedList<List<Integer>>();
		levelMaker(wrapList, root, 0);
		return wrapList;
	}

	public void levelMaker(List<List<Integer>> list, TreeNode root, int level) {
		if (root == null)
			return;
		if (level >= list.size()) {
			list.add(0, new LinkedList<Integer>());
		}
		levelMaker(list, root.left, level + 1);
		levelMaker(list, root.right, level + 1);
		list.get(list.size() - level - 1).add(root.val);
	}

}
