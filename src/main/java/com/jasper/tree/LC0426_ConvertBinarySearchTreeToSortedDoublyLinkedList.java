package com.jasper.tree;


public class LC0426_ConvertBinarySearchTreeToSortedDoublyLinkedList {

    static class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {
        }

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node left, Node right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    Node prev = null;
    Node head = null;

    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return root;
        }

        helper(root);

        prev.right = head;
        head.left = prev;

        return head;
    }


    private void helper(Node node) {
        if (head == null && node.left == null) {
            head = node;
        }


        if (node.left != null) {
            helper(node.left);
        }

        System.out.println(node.val);

        if (prev != null) {
            prev.right = node;
        }

        node.left = prev;


        prev = node;

        if (node.right != null) {
            helper(node.right);
        }
    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);

        node4.left = node2;
        node4.right = node5;
        node2.left = node1;
        node2.right = node3;

        LC0426_ConvertBinarySearchTreeToSortedDoublyLinkedList l = new LC0426_ConvertBinarySearchTreeToSortedDoublyLinkedList();
        l.treeToDoublyList(node4);
    }
}
