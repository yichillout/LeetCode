package com.jasper.tree;

import java.util.LinkedList;
import java.util.Queue;

public class LC0958_CheckCompletenessOfABinaryTree {

    public boolean isCompleteTree(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        boolean isEnd = false;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                isEnd = true;
            } else {
                if (isEnd) {
                    return false;
                }
                queue.offer(node.left);
                queue.offer(node.right);
            }
        }

        return true;
    }
}
