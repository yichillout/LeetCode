package com.jasper.tree;

import com.jasper.common.TreeNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LC1110_DeleteNodesAndReturnForest {

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> result = new ArrayList<>();
        Set<Integer> deleteSet = new HashSet<>();
        for (int d : to_delete) {
            deleteSet.add(d);
        }
        dfs(root, null, false, result, deleteSet);
        if (!deleteSet.contains(root.val)) {
            result.add(root);
        } else {
            if (root.left != null) {
                result.add(root.left);
                root.left = null;
            }

            if (root.right != null) {
                result.add(root.right);
                root.right = null;
            }
        }
        return result;
    }

    public void dfs(TreeNode node, TreeNode parent, boolean isLeft, List<TreeNode> result, Set<Integer> deleteSet) {
        if (node == null) {
            return;
        }

        dfs(node.left, node, true, result, deleteSet);
        dfs(node.right, node, false, result, deleteSet);

        if (deleteSet.contains(node.val)) {
            if (parent != null) {
                if (isLeft) {
                    parent.left = null;
                } else {
                    parent.right = null;
                }
            }

            if (node.left != null) {
                result.add(node.left);
                node.left = null;
            }

            if (node.right != null) {
                result.add(node.right);
                node.right = null;
            }
        }
    }
}
