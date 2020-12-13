package com.jasper.tree;

import com.jasper.common.TreeNode;

public class LC0337_HouseRobberIII {

	public int rob(TreeNode root) {
		int[] result = robHelper(root);
		return result[0];
	}

	public int[] robHelper(TreeNode node) {

		if (node == null)
			return new int[2];

		int[] dpLeft = robHelper(node.left);
		int[] dpRight = robHelper(node.right);

		int[] res = new int[2];

		res[1] = dpLeft[0] + dpRight[0];
		res[0] = Math.max(dpLeft[1] + dpRight[1] + node.val, res[1]);

		return res;
	}

}
