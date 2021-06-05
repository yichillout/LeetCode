package com.jasper.tree;

import java.util.*;

import com.jasper.common.TreeNode;

public class LC0515_FindLargestValueinEachTreeRow {

	// Solution 1 : DFS
	public List<Integer> largestValues1(TreeNode root) {
		List<Integer> result = new ArrayList<Integer>();
		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();

		traverse(root, result, 0, hm);
		for (int i = 0; i < hm.size(); i++) {
			result.add(hm.get(i));
		}
		return result;
	}

	public void traverse(TreeNode node, List<Integer> result, int level,
			HashMap<Integer, Integer> hm) {

		if (node == null)
			return;

		if (!hm.containsKey(level)) {
			hm.put(level, node.val);
		} else {
			if (node.val > hm.get(level)) {
				hm.put(level, node.val);
			}
		}
		traverse(node.left, result, level + 1, hm);
		traverse(node.right, result, level + 1, hm);
	}

	// Solution 2 : BFS
	public List<Integer> largestValues2(TreeNode root) {

		List<Integer> result = new ArrayList<Integer>();
		Queue<TreeNode> q = new LinkedList<TreeNode>();

		if (root == null)
			return result;

		q.offer(root);

		while (!q.isEmpty()) {
			int size = q.size();
			int max = Integer.MIN_VALUE;
			for (int i = 0; i < size; i++) {
				TreeNode node = q.poll();
				max = Math.max(max, node.val);
				if (node.left != null)
					q.offer(node.left);
				if (node.right != null)
					q.offer(node.right);
			}

			result.add(max);
		}

		return result;
	}

}
