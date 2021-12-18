package com.jasper.tree;

import java.util.HashSet;
import java.util.Set;

import com.common.TreeNode;

public class LC1676_LowestCommonAncestorOfABinaryTreeIV {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode[] nodes) {
        Set<Integer> nodeSet = new HashSet<>();

        for (TreeNode node : nodes) {
            nodeSet.add(node.val);
        }

        return helper(root, nodeSet);
    }

    public TreeNode helper(TreeNode node, Set<Integer> nodeSet) {
        if (node == null) {
            return null;
        }

        TreeNode left = helper(node.left, nodeSet);
        TreeNode right = helper(node.right, nodeSet);

        if (left != null && right != null) {
            return node;
        }

        if (nodeSet.contains(node.val)) {
            return node;
        }

        return left != null ? left : right;
    }
}
