package com.jasper.tree;

import com.jasper.common.TreeNode;
import com.jasper.twopointers.ListNode;

public class LC0109_ConvertSortedListtoBinarySearchTree {

	private ListNode current;

	// Solution 1
	public TreeNode sortedListToBST1(ListNode head) {
		int size;

		current = head;
		size = getListLength(head);

		return sortedListToBSTHelper(size);
	}

	private int getListLength(ListNode head) {
		int size = 0;

		while (head != null) {
			size++;
			head = head.next;
		}

		return size;
	}

	public TreeNode sortedListToBSTHelper(int size) {
		if (size <= 0) {
			return null;
		}

		TreeNode left = sortedListToBSTHelper(size / 2);
		TreeNode root = new TreeNode(current.val);
		current = current.next;
		TreeNode right = sortedListToBSTHelper(size - 1 - size / 2);

		root.left = left;
		root.right = right;

		return root;
	}

	// Solution 2
	public static TreeNode sortedListToBST2(ListNode head) {

		if (head == null) {
			return null;
		}

		// to prevent pre is null in the following code
		// if (head.next == null)
		// return new TreeNode(head.val);

		ListNode slow = head;
		ListNode fast = head;
		ListNode pre = head;

		while (fast != null && fast.next != null) {
			pre = slow;
			slow = slow.next;
			fast = fast.next.next;
		}

		pre.next = null;

		TreeNode node = new TreeNode(slow.val);

		if (head != slow) {
			node.left = sortedListToBST2(head);
		} else {
			node.left = null;
		}

		node.right = sortedListToBST2(slow.next);

		return node;
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);
		ListNode node6 = new ListNode(6);
		ListNode node7 = new ListNode(7);

		head.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		node6.next = node7;

		TreeNode node = sortedListToBST2(head);

	}

}
