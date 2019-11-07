package com.jasper.linkedlist;

import com.jasper.twopointers.ListNode;

public class LC0021_MergeTwoSortedLists {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

		if (l1 == null)
			return l2;

		if (l2 == null)
			return l1;

		ListNode dummy = new ListNode(-1);
		ListNode cur = dummy;

		while (l1 != null && l2 != null) {

			ListNode newNode = new ListNode(0);

			if (l1.val > l2.val) {
				cur.next = l2;
				l2 = l2.next;
			} else {
				cur.next = l1;
				l1 = l1.next;
			}
			cur = cur.next;
		}

		if (l1 != null) {
			cur.next = l1;
		} else {
			cur.next = l2;
		}

		return dummy.next;
	}
}
