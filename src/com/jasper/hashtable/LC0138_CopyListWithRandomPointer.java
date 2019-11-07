package com.jasper.hashtable;

import java.util.HashMap;
import java.util.Map;

class Node {
	public int val;
	public Node next;
	public Node random;

	public Node() {
	}

	public Node(int _val, Node _next, Node _random) {
		val = _val;
		next = _next;
		random = _random;
	}
};

public class LC0138_CopyListWithRandomPointer {

	// Solutin 1 : space O(N)
	public Node copyRandomList1(Node head) {

		if (head == null) {
			return null;
		}

		Map<Node, Node> map = new HashMap<>();

		Node cur = head;

		while (cur != null) {
			map.put(cur, new Node(cur.val, null, null));
			cur = cur.next;
		}

		cur = head;

		while (cur != null) {
			map.get(cur).next = map.get(cur.next);
			map.get(cur).random = map.get(cur.random);
			cur = cur.next;
		}

		return map.get(head);
	}

	// Solution 2 : no hashmap
	/*
	 *      +--+ 
	 * src: 1->2->3
	 * 
	 * 
	 * step1: copy node 
	 *      +------+ 
	 * src: 1->1'->2->2'->3->3'
	 * 
	 * 
	 * step2: copy random link 
	 *      +------+ 
	 * src: 1->1'->2->2'->3->3' 
	 *         +------+
	 * 
	 * step3: split two lists 
	 *      +--+ 
	 * src: 1->2->3
	 * 
	 *      +---+ 
	 * dst: 1'->2'->3'
	 */
	public Node copyRandomList2(Node head) {
	        
	        if(head == null)
	            return null;
	        
	        Node cur = head;
	        
	        while(cur != null) {
	            Node newNode = new Node(cur.val, null, null);
	            newNode.next = cur.next;
	            cur.next = newNode;
	            cur = cur.next.next;
	        }
	        
	        cur = head;
	        while(cur != null) {
	            if(cur.random != null) {
	                cur.next.random = cur.random.next;
	            }
	            cur = cur.next.next;
	        }
	        
	        Node dummy = new Node(-1, null, null);
	        Node cur1 = dummy;
	        
	        cur = head;
	        while(cur != null) {
	            Node copyNode = cur.next;
	            cur.next = copyNode.next;
	            cur1.next = copyNode;
	            cur1 = copyNode;
	            cur = cur.next;
	        }
	        
			return dummy.next;
	}        
}
