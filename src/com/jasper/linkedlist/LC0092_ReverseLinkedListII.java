package com.jasper.linkedlist;

import com.jasper.twopointers.ListNode;

//1->2->3->4->5->NULL, m = 2 and n = 4
//1->4->3->2->5->NULL
public class LC0092_ReverseLinkedListII {

	public ListNode reverseBetween(ListNode head, int m, int n) {

		if (head == null || head.next == null || m > n)
			return head;

		ListNode dummy = new ListNode(-1);
		dummy.next = head;
		ListNode pre = dummy;

		for (int i = 0; i < m - 1; i++) {
			pre = pre.next;
		}

		ListNode start = pre.next;
		ListNode then = start.next;

		for (int i = 0; i < n - m; i++) {
			start.next = then.next;
			then.next = pre.next;
			pre.next = then;
			then = start.next;
		}

		return dummy.next;

		// first reversing :
		// dummy->1 - 3 - 2 - 4 - 5; pre = 1, start = 2, then = 4
		// second reversing:
		// dummy->1 - 4 - 3 - 2 - 5; pre = 1, start = 2, then = 5 (finish)

	}

}
