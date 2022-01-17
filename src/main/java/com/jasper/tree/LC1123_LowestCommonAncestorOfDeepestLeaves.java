package com.jasper.tree;

import com.common.TreeNode;

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
    class Pair {
        TreeNode node;
        int d;

        Pair(TreeNode node, int d) {
            this.node = node;
            this.d = d;
        }
    }

    public TreeNode lcaDeepestLeaves2(TreeNode root) {
        Pair p = getLca(root, 0);
        return p.node;
    }

    private Pair getLca(TreeNode root, int d) {
        if (root == null) {
            return new Pair(null, d);
        }

        Pair l = getLca(root.left, d + 1);
        Pair r = getLca(root.right, d + 1);

        if (l.d == r.d) {
            return new Pair(root, l.d);
        }

        return l.d > r.d ? l : r;
    }
}
