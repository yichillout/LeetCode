package com.jasper.tree;

import java.util.*;

import com.jasper.common.TreeNode;

public class LC0100_SameTree {
	public boolean isSameTree(TreeNode p, TreeNode q) {

		if (p == null && q == null) {
			return true;
		} else if (p == null || q == null) {
			return false;
		}

		if (p.val != q.val)
			return false;

		return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
	}
}
