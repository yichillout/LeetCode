package com.jasper.divideandconquer;

import com.jasper.common.TreeNode;

public class LC0298_BinaryTreeLongestConsecutiveSequence {

	class RT {
		int maxLen;
		int len;

		public RT(int maxLen, int len) {
			this.maxLen = maxLen;
			this.len = len;
		}
	}

	public int longestConsecutive(TreeNode root) {
		return helper(root).maxLen;
	}

	private RT helper(TreeNode node) {
		if (node == null) {
			return new RT(0, 0);
		}

		RT left = helper(node.left);
		RT right = helper(node.right);

		int len = 1;

		if (node.left != null && node.val + 1 == node.left.val) {
			if (left.len + 1 > len) {
				len = left.len + 1;
			}
		}

		if (node.right != null && node.val + 1 == node.right.val) {
			if (right.len + 1 > len) {
				len = right.len + 1;
			}
		}

		int maxLen = Math.max(len, Math.max(left.maxLen, right.maxLen));

		return new RT(maxLen, len);
	}
}
