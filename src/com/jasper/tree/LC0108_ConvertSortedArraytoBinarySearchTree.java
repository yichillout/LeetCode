package com.jasper.tree;

import com.jasper.common.TreeNode;

public class LC0108_ConvertSortedArraytoBinarySearchTree {

	public TreeNode sortedArrayToBST(int[] nums) {
		if (nums == null)
			return null;

		return buildTree(nums, 0, nums.length - 1);
	}

	private TreeNode buildTree(int[] nums, int start, int end) {
		if (start > end)
			return null;

		int mid = start + (end - start) / 2;

		TreeNode node = new TreeNode(nums[mid]);
		node.left = buildTree(nums, start, mid - 1);
		node.right = buildTree(nums, mid + 1, end);
		return node;
	}
}
