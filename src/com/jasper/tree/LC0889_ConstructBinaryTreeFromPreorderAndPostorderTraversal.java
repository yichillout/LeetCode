package com.jasper.tree;

import com.jasper.common.TreeNode;

class LC0889_ConstructBinaryTreeFromPreorderAndPostorderTraversal {
	
	int preStart;

	public TreeNode constructFromPrePost(int[] pre, int[] post) {

		// corner cases to add
		preStart = 0;
		int n = post.length;
		return constructFromPrePostFrom(pre, post, 0, n - 1);
	}

	private TreeNode constructFromPrePostFrom(int[] pre, int[] post, int postStart, int postEnd) {

		if (postStart > postEnd) {
			return null;
		}

		int rootVal = post[postEnd];
		TreeNode root = new TreeNode(rootVal);
		preStart++;

		if (preStart == pre.length || postStart == postEnd) {
			return root;
		}

		int leftVal = pre[preStart];
		int lri = postStart;
		for (; lri <= postEnd; lri++) {
			if (post[lri] == leftVal) {
				break;
			}
		}

		root.left = constructFromPrePostFrom(pre, post, postStart, lri);
		root.right = constructFromPrePostFrom(pre, post, lri + 1, postEnd - 1);

		return root;
	}
}
