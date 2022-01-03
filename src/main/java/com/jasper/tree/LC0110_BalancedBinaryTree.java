package com.jasper.tree;

import com.jasper.common.TreeNode;

public class LC0110_BalancedBinaryTree {

    public boolean isBalanced(TreeNode root) {
        return helper(root) != -1;
    }

    public int helper(TreeNode node) { // if it is balance, return the height of the tree
        if (node == null) {
            return 0;
        }

        int left = helper(node.left);
        if (left == -1) {
            return -1;
        }

        int right = helper(node.right);
        if (right == -1) {
            return -1;
        }

        return Math.abs(left - right) > 1 ? -1 : Math.max(left, right) + 1;
    }
}
