package com.company.bloomberg;

import com.sun.xml.internal.bind.marshaller.NoEscapeHandler;

class InsertSortLinkedList {

    class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    Node head;

    void sortedInsert(Node newNode) {
        Node cur;

        if (head == null || head.data >= newNode.data) {
            newNode.next = head;
            head = newNode;
        } else {
            cur = head;
            while (cur.next != null && cur.next.data < newNode.data) {
                cur = cur.next;
            }
            newNode.next = cur.next;
            cur.next = newNode;
        }
    }

    Node newNode(int data) {
        Node x = new Node(data);
        return x;
    }

    void printList() {
        Node cur = head;
        while (cur != null) {
            System.out.print(cur.data + " ");
            cur = cur.next;
        }
    }

    public static void main(String args[]) {
        InsertSortLinkedList list = new InsertSortLinkedList();
        Node newNode;
        newNode = list.newNode(5);
        list.sortedInsert(newNode);
        newNode = list.newNode(10);
        list.sortedInsert(newNode);
        newNode = list.newNode(7);
        list.sortedInsert(newNode);
        newNode = list.newNode(3);
        list.sortedInsert(newNode);
        newNode = list.newNode(1);
        list.sortedInsert(newNode);
        newNode = list.newNode(9);
        list.sortedInsert(newNode);
        System.out.println("Created Linked List");
        list.printList();
    }
}