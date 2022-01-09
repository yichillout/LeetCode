package com.jasper.linkedlist;

public class LC0430_FlattenAMultilevelDoublyLinkedList {

    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    }

    // solution 1 : cur != null
    public Node flatten1(Node head) {

        Node cur = head;

        while (cur != null) {
            if (cur.child == null) {
                cur = cur.next;
                continue;
            }

            Node curChild = cur.child;

            while (curChild.next != null) {
                curChild = curChild.next;
            }

            Node next = cur.next;

            cur.next = cur.child;
            cur.child.prev = cur;
            cur.child = null;

            curChild.next = next;

            if (next != null) {
                next.prev = curChild;
            }

            cur = cur.next;

        }


        return head;
    }

    // solution 2 : cur.next != null
    public Node flatten2(Node head) {

        Node dummy = new Node();
        dummy.next = head;

        Node cur = dummy;

        while (cur.next != null) {
            cur = cur.next;

            if (cur.child == null) {
                continue;
            }

            Node curChild = cur.child;

            while (curChild.next != null) {
                curChild = curChild.next;
            }

            Node next = cur.next;

            cur.next = cur.child;
            cur.child.prev = cur;
            cur.child = null;

            curChild.next = next;

            if (next != null) {
                next.prev = curChild;
            }

        }


        return dummy.next;
    }
}
