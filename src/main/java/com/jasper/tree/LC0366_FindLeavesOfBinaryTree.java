package com.jasper.tree;

import java.util.ArrayList;
import java.util.List;

public class LC0366_FindLeavesOfBinaryTree {

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

    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        findLeavesHelper(list, root);
        return list;
    }

    // return the level of root
    private int findLeavesHelper(List<List<Integer>> list, TreeNode root) {
        if (root == null) {
            return -1;
        }
        int leftLevel = findLeavesHelper(list, root.left);
        int rightLevel = findLeavesHelper(list, root.right);

        int level = Math.max(leftLevel, rightLevel) + 1;

        if (list.size() == level) {
            list.add(new ArrayList<>());
        }

        list.get(level).add(root.val);
        root.left = null;
        root.right = null;

        return level;
    }
}
