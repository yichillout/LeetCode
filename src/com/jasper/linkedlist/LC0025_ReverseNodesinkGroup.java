package com.jasper.linkedlist;

import com.jasper.twopointers.ListNode;

public class LC0025_ReverseNodesinkGroup {

	public ListNode reverseKGroup(ListNode head, int k) {
		
		if (head == null)
			return null;
		
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode pre = dummy;
		ListNode cur = head;
		
		while (cur != null) {
			ListNode pilot = pre.next;
			int remaining = k;
			while (pilot != null && remaining > 0) {
				remaining--;
				pilot = pilot.next;
			}
			if (remaining > 0)
				break;
			while (cur.next != pilot) {
				ListNode tmp = cur.next.next;
				cur.next.next = pre.next;
				pre.next = cur.next;
				cur.next = tmp;
			}
			pre = cur;
			cur = cur.next;
		}
		
		return dummy.next;
	}

}
