package com.jasper.linkedlist;

import com.jasper.twopointers.ListNode;

public class LC0369_PlusOneLinkedList {

	// 1->2->3->4 : 1->2->3->5 (4 is the first not 9 number)
	// 7->8->9->9 : 7->9->0->0 (8 is the first not 9 number)
	// 4->5->9->3 : 4->5->9->4 (3 is the first not 9 number)

	public ListNode plusOne(ListNode head) {
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode i = dummy;
		ListNode j = dummy;

		while (j.next != null) {
			j = j.next;
			if (j.val != 9) {
				i = j;
			}
		}

		if (j.val != 9) {
			j.val++;
		} else {
			i.val++;
			i = i.next;
			while (i != null) {
				i.val = 0;
				i = i.next;
			}
		}

		if (dummy.val == 0) {
			return dummy.next;
		}

		return dummy;
	}

}
