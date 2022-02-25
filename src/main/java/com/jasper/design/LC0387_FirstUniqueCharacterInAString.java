package com.jasper.design;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


class FirstCharData {

    class Node {
        char value;
        int index;
        Node next;

        public Node(char value, int index) {
            this.value = value;
            this.index = index;
        }
    }

    Map<Character, Node> map;
    Set<Character> dupSet;
    Node head;
    Node tail;

    public FirstCharData() {
        map = new HashMap<>();
        dupSet = new HashSet<>();
        head = new Node('#', -1);
        tail = head;
    }

    public void add(char c, int index) {
        if (dupSet.contains(c)) {
            return;
        }

        if (map.containsKey(c)) {
            Node prev = map.get(c);
            prev.next = prev.next.next;
            map.remove(c);
            dupSet.add(c);

            if (prev.next == null) {
                tail = prev;
            } else {
                map.put(prev.next.value, prev);
            }

            return;
        }

        tail.next = new Node(c, index);
        map.put(c, tail);
        tail = tail.next;
    }

    public int getFirstCharIndex() {
        return head == tail ? -1 : head.next.index;
    }
}


public class LC0387_FirstUniqueCharacterInAString {

    public static void main(String[] args) {
        String s = "leetlcode";
        FirstCharData ds = new FirstCharData();

        for (int i = 0; i < s.length(); i++) {
            ds.add(s.charAt(i), i);
        }

        System.out.println(ds.getFirstCharIndex());
    }
}
