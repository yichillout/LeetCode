package com.jasper.linkedlist;

import com.jasper.twopointers.ListNode;

public class LC0002_AddTwoNumbers {

	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

		ListNode dummy = new ListNode(-1);
		ListNode cur = dummy;
		int carry = 0;

		while (l1 != null || l2 != null) {

			int val1 = 0;
			int val2 = 0;

			if (l1 == null) {
				val1 = 0;
			} else {
				val1 = l1.val;
			}

			if (l2 == null) {
				val2 = 0;
			} else {
				val2 = l2.val;
			}

			cur.next = new ListNode((val1 + val2 + carry) % 10);
			if (val1 + val2 + carry >= 10) {
				carry = (val1 + val2 + carry) / 10;
			} else {
				carry = 0;
			}

			if (l1 != null)
				l1 = l1.next;

			if (l2 != null)
				l2 = l2.next;

			cur = cur.next;
		}

		if (carry != 0)
			cur.next = new ListNode(carry);

		return dummy.next;
	}

	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		// l1.next = new ListNode(4);
		// l1.next.next = new ListNode(3);

		ListNode l2 = new ListNode(9);
		l2.next = new ListNode(8);
		// l2.next.next = new ListNode(4);

		ListNode resutl = addTwoNumbers(l1, l2);
	}
}
