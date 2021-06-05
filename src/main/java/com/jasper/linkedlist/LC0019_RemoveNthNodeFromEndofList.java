package com.jasper.linkedlist;

import com.jasper.twopointers.ListNode;

public class LC0019_RemoveNthNodeFromEndofList {

	public ListNode removeNthFromEnd(ListNode head, int n) {

		if (head == null)
			return head;

		ListNode dummy = new ListNode(-1);
		dummy.next = head;
		ListNode prev = dummy;
		ListNode cur = head;

		int nodeCount = 0;
		while (cur != null) {
			cur = cur.next;
			nodeCount++;
		}

		cur = head;
		int step = nodeCount - n;

		for (int i = 0; i < step; i++) {
			cur = cur.next;
			prev = prev.next;
		}

		prev.next = cur.next;
		cur.next = null;

		return dummy.next;
	}

}
