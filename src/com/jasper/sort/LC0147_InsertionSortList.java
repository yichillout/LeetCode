package com.jasper.sort;

import com.jasper.twopointers.ListNode;

public class LC0147_InsertionSortList {
	public ListNode insertionSortList(ListNode head) {
		ListNode dummy = new ListNode(0);
		// 这个dummy的作用是，把head开头的链表一个个的插入到dummy开头的链表里
		// 所以这里不需要dummy.next = head;

		while (head != null) {
			ListNode node = dummy;
			while (node.next != null && node.next.val < head.val) {
				node = node.next;
			}
			ListNode temp = head.next;
			head.next = node.next;
			node.next = head;
			head = temp;
		}
		return dummy.next;
	}
}
