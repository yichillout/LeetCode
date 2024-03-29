package com.jasper.linkedlist;

import com.jasper.twopointers.ListNode;

// 1->2->3->4->5->NULL
// 5->4->3->2->1->NULL

public class LC0206_ReverseLinkedList {

    public ListNode reverseList(ListNode head) {
        ListNode cur = head;
        ListNode prev = null;

        while (cur != null) {
            ListNode then = cur.next;
            cur.next = prev;
            prev = cur;
            cur = then;
        }

        return prev;
    }

}
