package com.jasper.design;

import java.util.*;

class LRUCache {

	class Node {
		int key;
		int value;
		Node prev;
		Node next;

		public Node(int key, int value) {
			this.key = key;
			this.value = value;
			this.prev = null;
			this.next = null;
		}
	}

	private int capacity;
	Node head;
	Node tail;
	Map<Integer, Node> map;

	public LRUCache(int capacity) {
		this.capacity = capacity;
		this.head = new Node(-1, -1);
		this.tail = new Node(-1, -1);
		this.map = new HashMap<>();
		head.next = tail;
		tail.prev = head;
	}

	public int get(int key) {
		if (!map.containsKey(key)) {
			return -1;
		}

		// remove node
		Node node = map.get(key);
		node.prev.next = node.next;
		node.next.prev = node.prev;

		// move the node to head;
		moveToHead(node);

		return map.get(key).value;
	}

	public void put(int key, int value) {
		// at here the get(int key) method already move the node to the head
		if (get(key) != -1) {
			map.get(key).value = value;
			return;
		}

		if (map.size() == capacity) {
			map.remove(tail.prev.key);
			tail.prev = tail.prev.prev;
			tail.prev.next = tail;
		}

		Node newNode = new Node(key, value);
		map.put(key, newNode);
		moveToHead(newNode);
	}

	private void moveToHead(Node node) {
		node.next = head.next;
		head.next.prev = node;
		node.prev = head;
		head.next = node;
	}
}

public class LC0146_LRUCache {

	public static void main(String[] args) {
		LRUCache cache = new LRUCache(2 /* capacity */);

		cache.put(1, 1);
		cache.put(2, 2);
		System.out.println(cache.get(1)); // returns 1
		cache.put(3, 3); // evicts key 2
		System.out.println(cache.get(2)); // returns -1 (not found)
		cache.put(4, 4); // evicts key 1
		System.out.println(cache.get(1)); // returns -1 (not found)
		System.out.println(cache.get(3)); // returns 3
		System.out.println(cache.get(4)); // returns 4
	}

}