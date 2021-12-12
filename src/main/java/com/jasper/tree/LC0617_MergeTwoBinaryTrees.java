package com.jasper.tree;

public class LC0617_MergeTwoBinaryTrees {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return null;
        }

        int val = (root1 == null ? 0 : root1.val) + (root2 == null ? 0 : root2.val);

        TreeNode newNode = new TreeNode(val);

        newNode.left = mergeTrees(root1 == null ? null : root1.left, root2 == null ? null : root2.left);
        newNode.right = mergeTrees(root1 == null ? null : root1.right, root2 == null ? null : root2.right);

        return newNode;
    }
}
