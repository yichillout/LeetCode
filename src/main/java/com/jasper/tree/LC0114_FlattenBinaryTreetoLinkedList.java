package com.jasper.tree;

import com.jasper.common.TreeNode;

public class LC0114_FlattenBinaryTreetoLinkedList {

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        TreeNode cur1 = root;
        TreeNode cur2 = null;
        while (cur1 != null) {
            if (cur1.left != null) {
                cur2 = cur1.left;
                while (cur2.right != null) {
                    cur2 = cur2.right;
                }
                cur2.right = cur1.right;
                cur1.right = cur1.left;
                cur1.left = null;
            }
            cur1 = cur1.right;
        }
    }
}
