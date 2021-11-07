package com.jasper.tree;

import java.util.HashMap;
import java.util.Map;

public class LC1123_LowestCommonAncestorOfDeepestLeaves {

    // solution 1
    int deepest = 0;
    TreeNode lca;

    public TreeNode lcaDeepestLeaves1(TreeNode root) {
        helper(root, 0);
        return lca;
    }

    private int helper(TreeNode node, int depth) {
        deepest = Math.max(deepest, depth);

        if (node == null) {
            return depth;
        }

        int left = helper(node.left, depth + 1);
        int right = helper(node.right, depth + 1);

        if (left == deepest && right == deepest) {
            lca = node;
        }

        return Math.max(left, right);
    }

    // solution 2
    public TreeNode lcaDeepestLeaves2(TreeNode root) {
        if (root == null) {
            return null;
        }

        int left = height(root.left);
        int right = height(root.right);
        if (left == right) {
            return root;
        } else if (left > right) {
            return lcaDeepestLeaves2(root.left);
        } else {
            return lcaDeepestLeaves2(root.right);
        }
    }

    private int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(height(root.left), height(root.right));
    }
}
