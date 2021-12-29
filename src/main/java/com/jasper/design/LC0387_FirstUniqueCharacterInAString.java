package com.jasper.design;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class DataStream {
    private Map<Character, ListCharNode> charToPrev;
    private Set<Character> dupChars;
    private ListCharNode dummy, tail;

    public DataStream() {
        charToPrev = new HashMap<>();
        dupChars = new HashSet<>();
        dummy = new ListCharNode('.', -1);
        tail = dummy;
    }

    public void add(char c, int index) {
        if (dupChars.contains(c)) {
            return;
        }

        if (!charToPrev.containsKey(c)) {
            ListCharNode node = new ListCharNode(c, index);
            charToPrev.put(c, tail);
            tail.next = node;
            tail = node;
            return;
        }

        // delete the existing node
        ListCharNode prev = charToPrev.get(c);
        prev.next = prev.next.next;
        if (prev.next == null) {
            // tail node removed
            tail = prev;
        } else {
            charToPrev.put(prev.next.val, prev);
        }

        charToPrev.remove(c);
        dupChars.add(c);
    }

    public char firstUniqueChar() {
        return dummy.next.val;
    }

    public int firstUniqueCharIndex() {
        return dummy.next == null ? -1 : dummy.next.index;
    }

    class ListCharNode {
        public char val;
        public int index;
        public ListCharNode next;

        public ListCharNode(char val, int index) {
            this.val = val;
            this.index = index;
            this.next = null;
        }
    }
}

public class LC0387_FirstUniqueCharacterInAString {

    public static int firstUniqChar(String s) {
        DataStream ds = new DataStream();
        for (int i = 0; i < s.length(); i++) {
            ds.add(s.charAt(i), i);
        }
        return ds.firstUniqueCharIndex();
    }

    public static void main(String[] args) {
        firstUniqChar("aabb");
    }
}
