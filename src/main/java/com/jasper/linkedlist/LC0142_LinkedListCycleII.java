package com.jasper.linkedlist;

import com.jasper.twopointers.ListNode;

public class LC0142_LinkedListCycleII {

	public ListNode detectCycle(ListNode head) {

		ListNode fast = head;
		ListNode slow = head;

		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;

			if (fast == slow) {
				break;
			}
		}

		// if no cycle
		if (fast == null || fast.next == null) {
			return null;
		}

		slow = head;
		while (fast != slow) {
			fast = fast.next;
			slow = slow.next;
		}

		return slow;
	}

}
