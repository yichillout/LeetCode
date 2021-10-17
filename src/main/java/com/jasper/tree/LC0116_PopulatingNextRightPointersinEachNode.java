package com.jasper.tree;

import java.util.*;

class TreeLinkNode {
    int val;
    TreeLinkNode left, right, next;

    TreeLinkNode(int x) {
        val = x;
    }
}

public class LC0116_PopulatingNextRightPointersinEachNode {

    // solution 1
    public static void connect1(TreeLinkNode root) {

        if (root == null)
            return;

        if (root.left != null) {
            root.left.next = root.right;
        }

        if (root.next != null && root.right != null) {
            root.right.next = root.next.left;
        }

        connect1(root.left);
        connect1(root.right);
    }

    // solution 2 : BFS
    public void connect2(TreeLinkNode root) {

        Queue<TreeLinkNode> queue = new LinkedList<TreeLinkNode>();

        if (root == null)
            return;

        TreeLinkNode pre = null;
        root.next = null;

        queue.add(root);

        while (!queue.isEmpty()) {
            int count = queue.size(); // num of node in one level
            for (int i = 0; i < count; i++) {
                TreeLinkNode tempTreeNode = queue.poll();

                if (i == 0) {
                    tempTreeNode.next = null;
                } else {
                    tempTreeNode.next = pre;
                }

                pre = tempTreeNode;

                if (tempTreeNode.right != null) {
                    queue.add(tempTreeNode.right);
                }
                if (tempTreeNode.left != null) {
                    queue.add(tempTreeNode.left);
                }

            }
        }
    }

    public static void main(String[] args) {
        TreeLinkNode root = new TreeLinkNode(1);
        TreeLinkNode node2 = new TreeLinkNode(2);
        TreeLinkNode node3 = new TreeLinkNode(3);
        TreeLinkNode node4 = new TreeLinkNode(4);
        TreeLinkNode node5 = new TreeLinkNode(5);
        TreeLinkNode node6 = new TreeLinkNode(6);
        TreeLinkNode node7 = new TreeLinkNode(7);

        root.left = node2;
        root.right = node3;

        node2.left = node4;
        node2.right = node5;

        node3.left = node6;
        node3.right = node7;
    }
}
