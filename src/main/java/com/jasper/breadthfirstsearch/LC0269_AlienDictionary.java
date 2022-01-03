package com.jasper.breadthfirstsearch;

import java.util.*;

public class LC0269_AlienDictionary {

    public static String alienOrder(String[] words) {

        Map<Character, Set<Character>> map = new HashMap<>();
        Map<Character, Integer> degree = new HashMap<>();

        for (String word : words) {
            for (char c : word.toCharArray()) {
                degree.put(c, 0);
            }
        }

        for (int i = 0; i < words.length - 1; i++) {
            String cur = words[i];
            String next = words[i + 1];

            if (cur.length() > next.length() && cur.startsWith(next)) {
                return "";
            }

            int len = Math.min(cur.length(), next.length());

            for (int j = 0; j < len; j++) {
                char c1 = cur.charAt(j);
                char c2 = next.charAt(j);

                if (c1 != c2) {
                    if (!map.containsKey(c1)) {
                        map.put(c1, new HashSet<>());
                    }

                    Set<Character> set = map.get(c1);

                    if (!set.contains(c2)) {
                        set.add(c2);
                        map.put(c1, set);
                        degree.put(c2, degree.get(c2) + 1);
                    }

                    break; // important
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        Queue<Character> queue = new LinkedList<>();

        for (Map.Entry<Character, Integer> entry : degree.entrySet()) {
            if (entry.getValue() == 0) {
                queue.offer(entry.getKey());
            }
        }

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                char cur = queue.poll();
                sb.append(cur);
                if (map.containsKey(cur)) {
                    for (char c : map.get(cur)) {
                        degree.put(c, degree.get(c) - 1);
                        if (degree.get(c) == 0) {
                            queue.offer(c);
                        }
                    }
                }
            }
        }

        if (sb.length() != degree.size()) { // important
            return "";
        }

        return sb.toString();
    }

    public static void main(String[] args) {
//        System.out.println(alienOrder(new String[]{"wrt", "wrf", "wra", "er", "ett", "eta"}));
//        alienOrder(new String[]{"abc", "ab"});
//        alienOrder(new String[]{"abc", "abc"});
        System.out.println(alienOrder(new String[]{"z", "x", "a", "zb", "zx"}));
    }
}
