package com.jasper.tree;

import java.util.*;

import com.jasper.common.TreeNode;

public class LC0095_UniqueBinarySearchTreesII {

	public List<TreeNode> generateTrees(int n) {
		if (n <= 0)
			return new ArrayList<TreeNode>();
		return generateTrees(1, n);
	}

	private List<TreeNode> generateTrees(int lo, int hi) {

		List<TreeNode> res = new ArrayList<TreeNode>();

		if (lo > hi) {
			res.add(null);
			return res;
		}

		for (int i = lo; i <= hi; i++) {
			List<TreeNode> left = generateTrees(lo, i - 1);
			List<TreeNode> right = generateTrees(i + 1, hi);

			for (TreeNode l : left) {
				for (TreeNode r : right) {
					TreeNode root = new TreeNode(i);
					root.left = l;
					root.right = r;
					res.add(root);
				}
			}
		}
		return res;
	}

}
