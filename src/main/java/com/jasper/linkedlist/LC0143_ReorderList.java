package com.jasper.linkedlist;

import com.jasper.twopointers.ListNode;

public class LC0143_ReorderList {

	public static void reorderList(ListNode head) {
		if (head == null || head.next == null)
			return;
		ListNode prevMid = getPreMid(head);
		ListNode mid = prevMid.next;
		prevMid.next = null;
		ListNode reversedTail = reverse(mid);

		ListNode left = head, right = reversedTail;
		ListNode tmp = null;

		while (left.next != null) {
			tmp = left.next;
			left.next = right;
			right = right.next;
			left = left.next;
			left.next = tmp;
			left = left.next;
		}
		left.next = right;
	}

	private static ListNode getPreMid(ListNode head) {
		ListNode fast = head, slow = head, prev = head;
		while (fast != null && fast.next != null) {
			prev = slow;
			fast = fast.next.next;
			slow = slow.next;
		}
		return prev;
	}

	private static ListNode reverse(ListNode head) {

		if (head == null || head.next == null)
			return head;

		ListNode prev = null;
		ListNode cur = head;
		while (cur != null) {
			ListNode then = cur.next;
			cur.next = prev;
			prev = cur;
			cur = then;
		}
		return prev;
	}

	public static void main(String[] args) {
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);
		ListNode node6 = new ListNode(6);

		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		//node5.next = node6;

		reorderList(node1);
	}
}
