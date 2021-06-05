package com.jasper.linkedlist;

import com.jasper.twopointers.ListNode;

public class LC0082_RemoveDuplicatesfromSortedListII {

	//Input:  d->1->2->3->3->4->4->5
	//Output: d->1->2->5
	public ListNode deleteDuplicates(ListNode head) {

		if (head == null || head.next == null)
			return head;

		ListNode dummy = new ListNode(-1);
		dummy.next = head;
		ListNode cur = head;
		ListNode pre = dummy;

		while (cur != null) {
			while (cur.next != null && cur.next.val == cur.val) {
				cur = cur.next;
			}

			if (pre.next == cur) {
				pre = cur;
			} else {
				pre.next = cur.next;
			}

			cur = cur.next;
		}

		return dummy.next;
	}
}
