package com.jasper.linkedlist;

import com.jasper.twopointers.ListNode;

public class LC0083_RemoveDuplicatesfromSortedList {

	// input:  1->1->2->3->3
	// Output: 1->2->3

	public ListNode deleteDuplicates(ListNode head) {

		if (head == null || head.next == null)
			return head;

		ListNode dummy = new ListNode(-1);
		dummy.next = head;
		ListNode cur = head;

		while (cur != null && cur.next != null) {
			if (cur.val == cur.next.val) {
				cur.next = cur.next.next;
			} else {
				cur = cur.next;
			}
		}

		return dummy.next;
	}
}
