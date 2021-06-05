package com.jasper.linkedlist;

import com.jasper.twopointers.ListNode;

public class LC0234_PalindromeLinkedList {

	public static boolean isPalindrome(ListNode head) {

		if (head == null || head.next == null)
			return true;

		ListNode secondStart = partition(head);

		secondStart = reverseList(secondStart);

		while (head != null && secondStart != null) {
			if (head.val != secondStart.val) {
				return false;
			}
			head = head.next;
			secondStart = secondStart.next;
		}

		return true;
	}

	private static ListNode partition(ListNode head) {
		ListNode fast = head;
		ListNode slow = head;
		ListNode prev = head;
		while (fast != null && fast.next != null) {
			prev = slow;
			fast = fast.next.next;
			slow = slow.next;
		}

		prev.next = null;
		return slow;
	}

	public static ListNode reverseList(ListNode head) {

		if (head == null || head.next == null)
			return head;

		ListNode prev = null;
		ListNode cur = head;

		while (cur != null) {
			ListNode temp = cur.next;
			cur.next = prev;
			prev = cur;
			cur = temp;
		}

		return prev;
	}

}
