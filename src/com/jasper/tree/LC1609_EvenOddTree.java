package com.jasper.tree;

import com.jasper.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class LC1609_EvenOddTree {

    public boolean isEvenOddTree(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;

        while (!queue.isEmpty()) {

            int size = queue.size();

            int pre = -1;

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                if (level % 2 == 0 && node.val % 2 == 0) {
                    return false;
                } else if (level % 2 == 1 && node.val % 2 == 1) {
                    return false;
                }

                if (pre != -1) {
                    if (level % 2 == 0) {
                        if (pre >= node.val) {
                            return false;
                        }
                    } else {
                        if (pre <= node.val) {
                            return false;
                        }
                    }
                }
                pre = node.val;


                if (node.left != null) {
                    queue.add(node.left);
                }

                if (node.right != null) {
                    queue.add(node.right);
                }
            }

            level++;
        }

        return true;
    }
}
