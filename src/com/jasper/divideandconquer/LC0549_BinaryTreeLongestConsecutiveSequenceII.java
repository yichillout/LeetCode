package com.jasper.divideandconquer;

import com.jasper.common.TreeNode;

public class LC0549_BinaryTreeLongestConsecutiveSequenceII {

	class RT {
		int up;
		int down;
		int maxLen;

		public RT(int up, int down, int maxLen) {
			this.up = up;
			this.down = down;
			this.maxLen = maxLen;
		}
	}

	public int longestConsecutive(TreeNode root) {
		return helper(root).maxLen;
	}

	private RT helper(TreeNode node) {
		if (node == null) {
			return new RT(0, 0, 0);
		}

		RT left = helper(node.left);
		RT right = helper(node.right);

		int up = 1;
		if (node.left != null && node.val - 1 == node.left.val) {
			up = Math.max(up, left.up + 1);
		}
		if (node.right != null && node.val - 1 == node.right.val) {
			up = Math.max(up, right.up + 1);
		}

		int down = 1;
		if (node.left != null && node.val + 1 == node.left.val) {
			down = Math.max(down, left.down + 1);
		}
		if (node.right != null && node.val + 1 == node.right.val) {
			down = Math.max(down, right.down + 1);
		}

		int maxLen = Math.max(up + down - 1, Math.max(left.maxLen, right.maxLen));

		return new RT(up, down, maxLen);
	}
}
