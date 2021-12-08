package com.jasper.depthfirstsearch;

import com.jasper.common.TreeNode;

public class LC0098_ValidateBinarySearchTree {

    // solution 1 : use range
    public boolean isValidBST1(TreeNode root) {
        return helper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public boolean helper(TreeNode node, long min, long max) {
        if (node == null) {
            return true;
        }

        if (node.val < min || node.val > max) {
            return false;
        }

        return helper(node.left, min, (long) node.val - 1) && helper(node.right, (long) node.val + 1, max);
    }


    // solution 1 : use prev
    TreeNode prev = null;

    public boolean isValidBST2(TreeNode root) {
        if (root == null) {
            return true;
        }
        return helper(root);
    }

    public boolean helper(TreeNode node) {
        boolean flag = true;

        if (node.left != null) {
            flag &= helper(node.left);
        }

        if (prev != null && prev.val >= node.val) {
            flag = false;
        }

        prev = node;

        if (node.right != null) {
            flag &= helper(node.right);
        }

        return flag;
    }
}
