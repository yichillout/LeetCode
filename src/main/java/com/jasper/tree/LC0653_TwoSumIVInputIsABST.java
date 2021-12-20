package com.jasper.tree;

import com.common.TreeNode;

import java.util.HashSet;
import java.util.Set;

public class LC0653_TwoSumIVInputIsABST {

    // solution 1 : for all tree structure
    public boolean findTarget1(TreeNode root, int k) {
        return helper1(root, k, new HashSet<>());
    }

    public boolean helper1(TreeNode node, int target, Set<Integer> set) {
        if (node == null) {
            return false;
        }

        if (set.contains(target - node.val)) {
            return true;
        }

        set.add(node.val);

        boolean result = false;

        result |= helper1(node.left, target, set);
        result |= helper1(node.right, target, set);

        return result;
    }

    // solution 2 : for BST
    public boolean findTarget2(TreeNode root, int k) {
        return dfs(root, root, k);
    }

    public boolean dfs(TreeNode root, TreeNode cur, int k) {
        if (cur == null) {
            return false;
        }

        return search(root, cur, k - cur.val) || dfs(root, cur.left, k) || dfs(root, cur.right, k);
    }

    public boolean search(TreeNode root, TreeNode cur, int value) {
        if (root == null) {
            return false;
        }

        return (root.val == value && root != cur) || (root.val < value && search(root.right, cur, value)) || (root.val > value && search(root.left, cur, value));
    }
}
