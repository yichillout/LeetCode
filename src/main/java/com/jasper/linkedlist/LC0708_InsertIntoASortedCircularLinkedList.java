package com.jasper.linkedlist;

import java.util.ArrayList;
import java.util.List;

public class LC0708_InsertIntoASortedCircularLinkedList {

    class Node {
        public int val;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _next) {
            val = _val;
            next = _next;
        }
    }

    ;

    public Node insert(Node head, int insertVal) {

        Node newNode = new Node(insertVal);

        if (head == null) {
            newNode.next = newNode;
            return newNode;
        }

        Node cur = head.next;
        Node prev = head;

        while (cur != head) {
            if (insertVal >= prev.val && insertVal <= cur.val) {
                break;
            }

            if (cur.val < prev.val && (insertVal >= prev.val || insertVal <= cur.val)) {
                break;
            }

            prev = cur;
            cur = cur.next;
        }

        prev.next = newNode;
        newNode.next = cur;

        return head;
    }
}
