package com.jasper.tree;

import com.common.TreeNode;

public class LC1644_LowestCommonAncestorOfABinaryTreeII {

    int count = 0;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode lca = dfs(root, p, q);
        return count == 2 ? lca : null;
    }

    public TreeNode dfs(TreeNode node, TreeNode p, TreeNode q) {
        if (node == null) {
            return node;
        }

        TreeNode left = dfs(node.left, p, q);
        TreeNode right = dfs(node.right, p, q);

        if (node == p) {
            count++;
            return node;
        }

        if (node == q) {
            count++;
            return node;
        }

        if (left != null && right != null) {
            return node;
        }

        return left != null ? left : right;
    }
}
