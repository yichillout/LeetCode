package com.jasper.linkedlist;

import java.util.*;

import com.jasper.twopointers.ListNode;

class NodeComparator implements Comparator<ListNode> {
	public int compare(ListNode n1, ListNode n2) {
		return n1.val - n2.val;
	}
}

class LC0023_MergekSortedLists {

	public ListNode mergeKLists(ListNode[] lists) {

		PriorityQueue<ListNode> pq = new PriorityQueue<>(new NodeComparator());
		ListNode dummy = new ListNode(-1);
		ListNode cur = dummy;

		if (lists.length == 0)
			return dummy.next;

		for (int i = 0; i < lists.length; i++) {
			if (lists[i] != null) {
				pq.offer(lists[i]);
			}
		}

		while (!pq.isEmpty()) {
			ListNode item = pq.poll();
			cur.next = item;
			if (item.next != null) {
				pq.offer(item.next);
			}
			cur = cur.next;
		}

		return dummy.next;
	}
}