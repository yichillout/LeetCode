package com.jasper.linkedlist;

import com.jasper.twopointers.ListNode;

public class LC0147_InsertionSortList {

	public class Solution {
		public ListNode insertionSortList(ListNode head) {
			if (head == null || head.next == null){
				return head;
			}

			ListNode dummy = new ListNode(-1);

			while (head != null) {
				ListNode cur = dummy;

				while (cur.next != null && cur.next.val <= head.val)
					cur = cur.next;

				ListNode temp = head.next;
				head.next = cur.next;
				cur.next = head;
				head = temp;
			}

			return dummy.next;
		}
	}

}
