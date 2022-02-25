package com.jasper.BST;

import com.common.TreeNode;

public class LC0270_ClosestBinarySearchTreeValue {

    public int closestValue(TreeNode root, double target) {
        return dfs(root, target);
    }

    private int dfs(TreeNode node, double target) {
        if (node == null) {
            return -1;
        }

        int num = -1;
        if (target > node.val) {
            num = dfs(node.right, target);
        } else {
            num = dfs(node.left, target);
        }

        if (num != -1 && Math.abs(target - node.val) > Math.abs(target - num)) {
            return num;
        }

        return node.val;
    }
}
