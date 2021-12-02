package com.jasper.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class LC0272_ClosestBinarySearchTreeValueII {

    class TreeNode {
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

    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        Queue<Integer> queue = new LinkedList<>();

        collect(root, target, k, queue);

        List<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            result.add(queue.poll());
        }

        return result;
    }

    public void collect(TreeNode node, double target, int k, Queue<Integer> queue) {
        if (node == null) {
            return;
        }

        collect(node.left, target, k, queue);

        if (queue.size() == k) {
            if (Math.abs(target - node.val) < Math.abs(target - queue.peek())) {
                queue.poll();
            } else {
                return;
            }
        }

        queue.add(node.val);

        collect(node.right, target, k, queue);
    }
}
