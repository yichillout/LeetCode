package com.jasper.depthfirstsearch;

import com.jasper.common.TreeNode;

public class LC0098_ValidateBinarySearchTree {

    // solution 1 : use prev
    TreeNode prev = null;

    public boolean isValidBST1(TreeNode root) {

        if (root == null) {
            return true;
        }

        return helper(root);
    }

    public boolean helper(TreeNode node) {

        boolean flag = true;

        if (node.left != null) {
            flag &= helper(node.left);
        }

        if (prev != null && prev.val >= node.val) {
            flag = false;
        }

        prev = node;

        if (prev != null) {
            System.out.println(prev.val);
        }

        if (node.right != null) {
            flag &= helper(node.right);
        }

        return flag;
    }

	// solution 2 : use range
    public static boolean isValidBST2(TreeNode root) {
        return isValidBST(root, null, null);
    }

    private static boolean isValidBST(TreeNode root, Integer max, Integer min) {
        if (root == null) {
            return true;
        }
        // If the value of the node greater than the max, return false.
        if (max != null && root.val >= max) {
            return false;
        }
        // If the value of the node less than the min, return false.
        if (min != null && root.val <= min) {
            return false;
        }
        // recursion
        return isValidBST(root.left, root.val, min) && isValidBST(root.right, max, root.val);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(50);
        root.left = new TreeNode(25);
        root.right = new TreeNode(100);
        root.left.left = new TreeNode(10);
        System.out.println(isValidBST2(root));

        TreeNode root1 = new TreeNode(50);
        root1.left = new TreeNode(25);
        root1.right = new TreeNode(100);
        root1.left.left = new TreeNode(27);
        System.out.println(isValidBST2(root1));
    }
}
