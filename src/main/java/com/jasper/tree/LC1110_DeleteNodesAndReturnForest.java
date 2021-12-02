package com.jasper.tree;

import com.jasper.common.TreeNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LC1110_DeleteNodesAndReturnForest {

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {

        List<TreeNode> forest = new ArrayList<>();

        if (root == null) {
            return forest;
        }

        Set<Integer> set = new HashSet<>();

        for (int i : to_delete) {
            set.add(i);
        }

        deleteNodes(root, set, forest);

        if (!set.contains(root.val)) {
            forest.add(root);
        }

        return forest;
    }

    private TreeNode deleteNodes(TreeNode node, Set<Integer> set, List<TreeNode> forest) {
        if (node == null) {
            return null;
        }

        node.left = deleteNodes(node.left, set, forest);
        node.right = deleteNodes(node.right, set, forest);

        if (set.contains(node.val)) {
            if (node.left != null) {
                forest.add(node.left);
            }
            if (node.right != null) {
                forest.add(node.right);
            }
            return null;
        }

        return node;
    }
}
