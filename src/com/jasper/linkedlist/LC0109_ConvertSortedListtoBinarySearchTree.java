package com.jasper.linkedlist;

import com.jasper.common.TreeNode;
import com.jasper.twopointers.ListNode;

public class LC0109_ConvertSortedListtoBinarySearchTree {

	public TreeNode sortedListToBST(ListNode head) {
		
		if (head == null)
			return null;

		ListNode fast = head, slow = head, pre = head;

		while (fast != null && fast.next != null) {
			pre = slow;
			fast = fast.next.next;
			slow = slow.next;
		}

		pre.next = null;

		TreeNode root = new TreeNode(slow.val);

		if (head != slow) {
			root.left = sortedListToBST(head);
		} else {
			root.left = null;
		}

		root.right = sortedListToBST(slow.next);

		return root;
	}

}
