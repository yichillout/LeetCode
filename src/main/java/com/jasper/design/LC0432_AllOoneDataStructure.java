package com.jasper.design;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


class AllOne {

    // keyCount
    // hello=1
    // hello=2
    // hello=2, leet=1
    // hello=2, leet=1, hi=1
    // hello=2, leet=1, hi=2
    // hello=2, leet=1, hi=3

    // countKeys
    // head - tail
    // head - 1=[hello] - tail
    // head - 2=[hello] - tail
    // head - 1=[leet,hi] - 2=[hello] - tail
    // head - 1=[leet] - 2=[hello,hi] - tail
    // head - 1=[leet] - 2=[hello] - 3=[hi] - tail

    class Node {
        int count;
        Set<String> keys;

        Node prev;
        Node next;

        public Node(int count) {
            this.count = count;
            this.keys = new HashSet<>();
        }
    }

    Node head;
    Node tail;
    Map<String, Integer> keyCount;
    Map<Integer, Node> countKeys;

    public AllOne() {
        head = new Node(Integer.MIN_VALUE);
        tail = new Node(Integer.MAX_VALUE);
        head.next = tail;
        tail.prev = head;
        keyCount = new HashMap<>();
        countKeys = new HashMap<>();
    }

    public void inc(String key) {
        int oldCount = keyCount.getOrDefault(key, 0);
        keyCount.put(key, oldCount + 1);
        int count = keyCount.get(key);

        if (!countKeys.containsKey(count)) {
            countKeys.put(count, new Node(count));
        }

        Node node = countKeys.get(count);
        node.keys.add(key);

        Node oldNode = head;
        if (oldCount > 0) {
            oldNode = countKeys.get(oldCount);
            oldNode.keys.remove(key);
        }

        if (node.keys.size() == 1) {
            node.next = oldNode.next;
            node.prev = oldNode;
            oldNode.next.prev = node;
            oldNode.next = node;
        }

        if (oldNode != head && oldNode.keys.size() == 0) {
            oldNode.prev.next = node;
            node.prev = oldNode.prev;
        }
    }

    public void dec(String key) {
        if (!keyCount.containsKey(key)) {
            return;
        }

        int oldCount = keyCount.get(key);

        int count = oldCount - 1;
        keyCount.put(key, count);

        Node node = head;
        if (count > 0) {
            if (!countKeys.containsKey(count)) {
                countKeys.put(count, new Node(count));
            }
            node = countKeys.get(count);
            node.keys.add(key);
        }

        Node oldNode = countKeys.get(oldCount);
        oldNode.keys.remove(key);

        if (node.keys.size() == 1) {
            node.next = oldNode;
            node.prev = oldNode.prev;
            oldNode.prev.next = node;
            oldNode.prev = node;
        }

        if (oldNode != tail && oldNode.keys.size() == 0) {
            oldNode.next.prev = node;
            node.next = oldNode.next;
        }
    }

    public String getMaxKey() {
        if (tail.prev.keys.size() == 0) {
            return "";
        }
        return tail.prev.keys.iterator().next();
    }

    public String getMinKey() {
        if (head.next.keys.size() == 0) {
            return "";
        }
        return head.next.keys.iterator().next();
    }
}

public class LC0432_AllOoneDataStructure {
}
