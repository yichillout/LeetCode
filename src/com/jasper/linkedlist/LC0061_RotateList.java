package com.jasper.linkedlist;

import com.jasper.twopointers.ListNode;

public class LC0061_RotateList {
	public ListNode rotateRight(ListNode head, int k) {

		if (head == null || k == 0)
			return head;

		ListNode dummy = new ListNode(-1);
		dummy.next = head;
		ListNode cur = head;

		int nodeCount = 1;
		while (cur.next != null) {
			cur = cur.next;
			nodeCount++;
		}

		cur.next = head;

		k = nodeCount - k % nodeCount;

		for (int i = 0; i < k; i++) {
			cur = cur.next;
		}

		dummy.next = cur.next;
		cur.next = null;

		return dummy.next;
	}
}
