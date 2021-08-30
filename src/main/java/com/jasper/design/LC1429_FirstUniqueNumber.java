package com.jasper.design;

import java.util.HashMap;
import java.util.Map;

class Node {
    int val;
    Node prev;
    Node next;

    public Node(int val) {
        this.val = val;
    }
}

class FirstUnique {
    Map<Integer, Node> map = new HashMap<>();
    Node dummyHead = new Node(-1);
    Node tail = new Node(-1);

    public FirstUnique(int[] nums) {
        dummyHead.next = tail;
        tail.prev = dummyHead;

        for (int num : nums) {
            add(num);
        }
    }

    public int showFirstUnique() {
        return dummyHead.next != tail ? dummyHead.next.val : -1;
    }

    public void add(int value) {
        if (!map.containsKey(value)) {
            Node newNode = addToEnd(value);
            map.put(value, newNode);
        } else {
            if (map.get(value) != null) {
                removeNode(map.get(value));
                map.put(value, null);
            }
        }
    }

    public Node addToEnd(int value) {
        Node newNode = new Node(value);
        Node tmp = tail.prev;
        tmp.next = newNode;
        newNode.prev = tmp;
        newNode.next = tail;
        tail.prev = newNode;
        return newNode;
    }

    public void removeNode(Node node) {
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
        node = null;
    }
}

/**
 * Your FirstUnique object will be instantiated and called as such:
 * FirstUnique obj = new FirstUnique(nums);
 * int param_1 = obj.showFirstUnique();
 * obj.add(value);
 */


public class LC1429_FirstUniqueNumber {
}
