package com.jasper.design;

import java.util.*;

class LFUCache {

    private Node head = null;
    private int cap;
    private HashMap<Integer, Integer> valueHash;
    private HashMap<Integer, Node> nodeHash;

    public LFUCache(int capacity) {
        this.cap = capacity;
        valueHash = new HashMap<>();
        nodeHash = new HashMap<>();
    }

    public int get(int key) {
        if (valueHash.containsKey(key)) {
            increaseCount(key);
            return valueHash.get(key);
        }
        return -1;
    }

    public void put(int key, int value) {
        if (cap == 0)
            return;
        if (valueHash.containsKey(key)) {
            valueHash.put(key, value);
        } else {
            if (valueHash.size() < cap) {
                valueHash.put(key, value);
            } else {
                removeOld();
                valueHash.put(key, value);
            }
            addToHead(key);
        }
        increaseCount(key);
    }

    private void addToHead(int key) {
        if (head == null) {
            head = new Node(0);
            head.keys.add(key);
        } else if (head.count > 0) {
            Node node = new Node(0);
            node.keys.add(key);
            node.next = head;
            head.prev = node;
            head = node;
        } else {
            head.keys.add(key);
        }
        nodeHash.put(key, head);
    }

    private void increaseCount(int key) {
        Node node = nodeHash.get(key);
        node.keys.remove(key);

        if (node.next == null) {
            node.next = new Node(node.count + 1);
            node.next.prev = node;
            node.next.keys.add(key);
        } else if (node.next.count == node.count + 1) {
            node.next.keys.add(key);
        } else {
            Node tmp = new Node(node.count + 1);
            tmp.keys.add(key);
            tmp.prev = node;
            tmp.next = node.next;
            node.next.prev = tmp;
            node.next = tmp;
        }

        nodeHash.put(key, node.next);
        if (node.keys.size() == 0)
            remove(node);
    }

    private void removeOld() {
        if (head == null)
            return;
        int old = 0;
        for (int n : head.keys) {
            old = n;
            break;
        }
        head.keys.remove(old);
        if (head.keys.size() == 0)
            remove(head);
        nodeHash.remove(old);
        valueHash.remove(old);
    }

    private void remove(Node node) {
        if (node.prev == null) {
            head = node.next;
        } else {
            node.prev.next = node.next;
        }
        if (node.next != null) {
            node.next.prev = node.prev;
        }
    }

    class Node {
        public int count;
        public Set<Integer> keys;
        public Node prev;
        public Node next;

        public Node(int count) {
            this.count = count;
            keys = new LinkedHashSet<>();
            prev = next = null;
        }
    }
}

public class LC0460_LFUCache {

}
