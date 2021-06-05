package com.jasper.linkedlist;

import com.jasper.twopointers.ListNode;

public class LC0237_DeleteNodeinaLinkedList {

	public void deleteNode(ListNode node) {
		node.val = node.next.val;
		node.next = node.next.next;
	}

}
