package com.jasper.design;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


class AllOne {

    // keyToCount
    // hello=1
    // hello=2
    // hello=2, leet=1
    // hello=2, leet=1, hi=1
    // hello=2, leet=1, hi=2
    // hello=2, leet=1, hi=3

    // countToNode
    // head - tail
    // head - 1,[hello] - tail
    // head - 2,[hello] - tail
    // head - 1,[leet,hi] - 2,[hello] - tail
    // head - 1,[leet] - 2,[hello,hi] - tail
    // head - 1,[leet] - 2,[hello] - 3,[hi] - tail

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
    Map<String, Integer> keyToCount;
    Map<Integer, Node> countToNode;

    public AllOne() {
        head = new Node(Integer.MIN_VALUE);
        tail = new Node(Integer.MAX_VALUE);
        head.next = tail;
        tail.prev = head;
        keyToCount = new HashMap<>();
        countToNode = new HashMap<>();
    }


    public void inc(String key) {
        int oldCount = keyToCount.getOrDefault(key, 0);
        keyToCount.put(key, oldCount + 1);
        int count = keyToCount.get(key);

        // add new key to node
        if (!countToNode.containsKey(count)) {
            countToNode.put(count, new Node(count));
        }
        Node node = countToNode.get(count);
        node.keys.add(key);

        Node oldNode = head;
        if (oldCount > 0) {
            oldNode = countToNode.get(oldCount);
            oldNode.keys.remove(key);
        }

        // node.keys.size() == 1 means the node is new node
        // new node add to next of old node
        if (node.keys.size() == 1) {
            node.next = oldNode.next;
            node.prev = oldNode;
            oldNode.next.prev = node;
            oldNode.next = node;
        }

        // oldNode != head && oldNode.keys.size() == 0 means the oldNode should be removed
        if (oldNode != head && oldNode.keys.size() == 0) {
            oldNode.prev.next = node;
            node.prev = oldNode.prev;
            countToNode.remove(oldCount);
        }
    }

    public void dec(String key) {
        if (!keyToCount.containsKey(key)) {
            return;
        }

        int oldCount = keyToCount.get(key);
        int count = oldCount - 1;
        keyToCount.put(key, count);

        Node node = head;
        if (count == 0) {
            keyToCount.remove(key);
        } else {
            if (!countToNode.containsKey(count)) {
                countToNode.put(count, new Node(count));
            }
            node = countToNode.get(count);
            node.keys.add(key);
        }

        Node oldNode = countToNode.get(oldCount);
        oldNode.keys.remove(key);

        // node.keys.size() == 1 means the node is new node
        // new node add to prev of old node
        if (node.keys.size() == 1) {
            node.next = oldNode;
            node.prev = oldNode.prev;
            oldNode.prev.next = node;
            oldNode.prev = node;
        }

        // oldNode != tail && oldNode.keys.size() == 0 means the oldNode should be removed
        if (oldNode != tail && oldNode.keys.size() == 0) {
            oldNode.next.prev = node;
            node.next = oldNode.next;
            countToNode.remove(oldCount);
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
    /**
     * ["AllOne","inc","inc","inc","inc","inc","inc","dec", "dec","getMinKey","dec","getMaxKey","getMinKey"]
     * [[],["a"],["b"],["b"],["c"],["c"],["c"],["b"],["b"],[],["a"],[],[]]
     */
    public static void main(String[] args) {
        AllOne allOne = new AllOne();
        allOne.inc("a");
        allOne.inc("a");
        allOne.inc("b");
        allOne.inc("b");
        allOne.inc("c");
        allOne.inc("c");
        allOne.inc("c");
        allOne.dec("b");
        allOne.dec("b");
        allOne.dec("b");
        System.out.println(allOne.getMinKey());
        allOne.dec("a");
        System.out.println(allOne.getMinKey());
        System.out.println(allOne.getMaxKey());
    }
}
