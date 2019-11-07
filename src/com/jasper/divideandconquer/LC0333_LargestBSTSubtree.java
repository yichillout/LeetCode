package com.jasper.divideandconquer;

import com.jasper.common.TreeNode;

public class LC0333_LargestBSTSubtree {

	class RT {
		int maxBSTSize;
		TreeNode minNode;
		TreeNode maxNode;
		boolean isBST;

		public RT(int maxBSTSize, TreeNode minNode, TreeNode maxNode, boolean isBST) {
			this.maxBSTSize = maxBSTSize;
			this.minNode = minNode;
			this.maxNode = maxNode;
			this.isBST = isBST;
		}
	}

	public int largestBSTSubtree(TreeNode root) {
		return helper(root).maxBSTSize;
	}

	private RT helper(TreeNode node) {
		if (node == null) {
			return new RT(0, null, null, true);
		}

		RT left = helper(node.left);
		RT right = helper(node.right);

		int maxBSTSize = Math.max(left.maxBSTSize, right.maxBSTSize);

		if (left.isBST == false || right.isBST == false) {
			return new RT(maxBSTSize, null, null, false);
		}

		if (left.maxNode != null && left.maxNode.val >= node.val) {
			return new RT(maxBSTSize, null, null, false);
		}

		if (right.minNode != null && right.minNode.val <= node.val) {
			return new RT(maxBSTSize, null, null, false);
		}

		maxBSTSize = 1 + left.maxBSTSize + right.maxBSTSize;

		TreeNode minNode = null;
		if (left.minNode == null) {
			minNode = node;
		} else {
			minNode = left.minNode;
		}

		TreeNode maxNode = null;
		if (right.maxNode == null) {
			maxNode = node;
		} else {
			maxNode = right.maxNode;
		}

		return new RT(maxBSTSize, minNode, maxNode, true);
	}

}
