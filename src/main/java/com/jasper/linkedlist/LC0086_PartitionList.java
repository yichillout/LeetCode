package com.jasper.linkedlist;

import com.jasper.twopointers.ListNode;

public class LC0086_PartitionList {

	public ListNode partition(ListNode head, int x) {

		if (head == null || head.next == null)
			return head;

		ListNode leftHead = new ListNode(-1);
		ListNode rightHead = new ListNode(-1);
		ListNode curLeft = leftHead;
		ListNode curRight = rightHead;
		ListNode cur = head;

		while (cur != null) {
			if (cur.val < x) {
				curLeft.next = cur;
				curLeft = curLeft.next;
			} else {
				curRight.next = cur;
				curRight = curRight.next;
			}
			cur = cur.next;
		}

		curRight.next = null;
		curLeft.next = rightHead.next;

		return leftHead.next;
	}

}
