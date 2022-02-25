package com.jasper.tree;

import com.jasper.common.TreeNode;

public class LC0099_RecoverBinarySearchTree {

    TreeNode first = null;
    TreeNode second = null;
    TreeNode prev = new TreeNode(Integer.MIN_VALUE);

    public void recoverTree(TreeNode root) {
        inorderTraversal(root);
        if (first != null && second != null) {
            int tmp = first.val;
            first.val = second.val;
            second.val = tmp;
        }
    }

    public void inorderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }

        inorderTraversal(node.left);

        if (prev.val > node.val) {
            if (first == null) {
                first = prev;
                second = node;
            } else {
                second = node;
            }
        }
        prev = node;

        inorderTraversal(node.right);
    }

}
