package com.jasper.linkedlist;

import com.jasper.twopointers.ListNode;

public class LC0160_IntersectionofTwoLinkedLists {
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

		if (headA == null || headB == null)
			return null;

		ListNode curA = headA;
		ListNode curB = headB;

		while (curA != null && curB != null) {

			if (curA == curB) {
				return curA;
			}

			curA = curA.next;
			curB = curB.next;

			if (curA == curB)
				return curA;

			if (curA == null) {
				curA = headB;
			}

			if (curB == null) {
				curB = headA;
			}
		}

		return curA;
	}
}
