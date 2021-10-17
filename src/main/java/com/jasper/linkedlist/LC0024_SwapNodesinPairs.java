package com.jasper.linkedlist;

import com.jasper.twopointers.ListNode;

public class LC0024_SwapNodesinPairs {

    public static ListNode swapPairs(ListNode head) {

        if (head == null)
            return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head;

        while (cur != null && cur.next != null) {
            ListNode next = cur.next.next;
            cur.next.next = cur;
            pre.next = cur.next;
            if (next != null && next.next != null) {
                cur.next = next.next;
            } else {
                cur.next = next;
            }
            pre = cur;
            cur = next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        swapPairs(node1);
    }

}
