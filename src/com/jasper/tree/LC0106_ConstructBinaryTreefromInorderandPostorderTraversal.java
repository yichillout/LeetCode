package com.jasper.tree;

import java.util.HashMap;

import com.jasper.common.TreeNode;

public class LC0106_ConstructBinaryTreefromInorderandPostorderTraversal {
	
	public TreeNode buildTree(int[] inorder, int[] postorder) {
		if (inorder.length != postorder.length)
			return null;
		return helper(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
	}

	public TreeNode helper(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd) {

		if (inStart > inEnd)
			return null;

		TreeNode node = new TreeNode(postorder[postEnd]);

		int index = getIndex(inorder, inStart, inEnd, postorder[postEnd]);

		node.left = helper(inorder, inStart, index - 1, postorder, postStart, postStart + (index - inStart) - 1);
		node.right = helper(inorder, index + 1, inEnd, postorder, postStart + (index - inStart), postEnd - 1);

		return node;
	}

	public int getIndex(int[] inorder, int inStart, int inEnd, int target) {
		for (int i = inStart; i <= inEnd; i++) {
			if (inorder[i] == target) {
				return i;
			}
		}
		return -1;
	}
}
