package com.jasper.linkedlist;

class FrontMiddleBackQueue {

    class ListNode {
        int val;
        ListNode next;
        ListNode prev;

        public ListNode(int val) {
            this.val = val;
        }
    }

    ListNode dummy;
    ListNode tail;

    public FrontMiddleBackQueue() {
        dummy = new ListNode(Integer.MIN_VALUE);
        dummy.next = tail;
        tail.prev = dummy;
    }

    public void pushFront(int val) {
        ListNode head = dummy.next;
        ListNode newNode = new ListNode(val);
        dummy.next = newNode;
        newNode.prev = dummy;
        newNode.next = head;
        head.prev = newNode;
    }

    public void pushMiddle(int val) {
        ListNode middle = findMiddle();
    }

    public void pushBack(int val) {
        ListNode newNode = new ListNode(val);
        tail.next = newNode;
        newNode.prev = tail;
        tail = tail.next;
    }

    public int popFront() {
        if(tail == dummy) {
            return -1;
        }

        ListNode head = dummy.next;
        ListNode nextHead = head.next;
        head.next = null;
        head.prev = null;
        dummy.next = nextHead;
        nextHead.prev = dummy;
        return head.val;
    }

    public int popMiddle() {
        return -1;
    }

    public int popBack() {
        if(tail == dummy) {
            return -1;
        }

        int result = tail.val;
        ListNode prevTail = tail.prev;
        tail.prev = null;
        prevTail.next = null;
        tail = prevTail;
        return result;
    }

    public ListNode findMiddle() {
        ListNode cur1 = dummy;
        ListNode cur2 = tail;

        while (cur1 != cur2 && cur1.next != cur2) {
            cur1 = cur1.next;
            cur2 = cur2.prev;
        }

        return cur1;
    }
}

public class LC1670_DesignFrontMiddleBackQueue {

}
