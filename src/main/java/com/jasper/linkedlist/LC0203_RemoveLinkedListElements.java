package com.jasper.linkedlist;

import com.jasper.twopointers.ListNode;

public class LC0203_RemoveLinkedListElements {

	public ListNode removeElements(ListNode head, int val) {

		ListNode dummy = new ListNode(-1);
		dummy.next = head;
		ListNode cur = dummy;

		while (cur != null && cur.next != null) {
			if (cur.next.val == val) {
				cur.next = cur.next.next;
			} else {
				cur = cur.next;
			}
		}

		return dummy.next;
	}

}
