package com.jasper.tree;

public class LC1644_LowestCommonAncestorOfABinaryTreeII {

    boolean pFound = false;
    boolean qFound = false;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode LCA = LCA(root, p, q);
        return pFound && qFound ? LCA : null;
    }

    public TreeNode LCA(TreeNode node, TreeNode p, TreeNode q) {
        if (node == null) {
            return null;
        }

        TreeNode left = LCA(node.left, p, q);
        TreeNode right = LCA(node.right, p, q);

        if (node == p) {
            pFound = true;
            return node;
        }

        if (node == q) {
            qFound = true;
            return node;
        }

        if (left != null && right != null) {
            return node;
        }

        return left == null ? right : left;
    }
}
