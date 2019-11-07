package com.jasper.twopointers;

public class LC0086_PartitionList {
	public ListNode partition(ListNode head, int x) {
		ListNode head1 = new ListNode(0);
		ListNode head2 = new ListNode(0);
		ListNode p1 = head1;
		ListNode p2 = head2;
		while (head != null) {
			if (head.val < x) {
				p1.next = new ListNode(head.val);
				p1 = p1.next;
			} else {
				p2.next = new ListNode(head.val);
				p2 = p2.next;
			}
			head = head.next;
		}
		if (head2.next != null)
			p1.next = head2.next;
		return head1.next;
	}
}