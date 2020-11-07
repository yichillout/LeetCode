package com.jasper.tree;

import com.jasper.common.TreeNode;

public class LC0669_TrimABinarySearchTree {

    // this is binary search tree
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) {
            return root;
        }

        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.left, low, high);

        if (root.val > high) {
            return root.left;
        }

        if (root.val < low) {
            return root.right;
        }

        return root;
    }
}
