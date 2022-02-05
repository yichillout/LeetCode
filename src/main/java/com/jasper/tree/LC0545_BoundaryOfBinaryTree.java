package com.jasper.tree;

import java.util.ArrayList;
import java.util.List;

import com.jasper.common.TreeNode;

public class LC0545_BoundaryOfBinaryTree {

    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        res.add(root.val);
        dfsLeft(res, root.left);
        dfsLeaves(res, root.left);
        dfsLeaves(res, root.right);
        dfsRight(res, root.right);
        return res;
    }

    public void dfsLeft(List<Integer> res, TreeNode node) {
        if (node == null || (node.left == null && node.right == null)) {
            return;
        }

        res.add(node.val);

        if (node.left != null) {
            dfsLeft(res, node.left);
        } else {
            dfsLeft(res, node.right);
        }
    }

    public void dfsRight(List<Integer> res, TreeNode node) {
        if (node == null || (node.left == null && node.right == null)) {
            return;
        }

        if (node.right != null) {
            dfsRight(res, node.right);
        } else {
            dfsRight(res, node.left);
        }

        res.add(node.val); // add after child visit(reverse)
    }

    public void dfsLeaves(List<Integer> res, TreeNode node) {
        if (node == null) {
            return;
        }

        if (node.left == null && node.right == null) {
            res.add(node.val);
            return;
        }

        dfsLeaves(res, node.left);
        dfsLeaves(res, node.right);
    }
}
