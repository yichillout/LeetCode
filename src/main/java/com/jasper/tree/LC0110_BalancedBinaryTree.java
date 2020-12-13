package com.jasper.tree;

import com.jasper.common.TreeNode;

public class LC0110_BalancedBinaryTree {

    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        return Math.abs(rightHeight - leftHeight) < 2 && isBalanced(root.left) && isBalanced(root.right);
    }
    
    public int height(TreeNode root) {
        if(root == null) return 0;
        if(root.left == null && root.right == null) return 1;
        return 1 + Math.max(height(root.left),height(root.right));
    }


}
