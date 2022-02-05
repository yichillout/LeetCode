package com.jasper.heap;

import java.util.*;

public class LC0451_SortCharactersByFrequency {

    /**
     * solution 1 : Bucket sort
     * <p>
     * tree -> [0 -> [], 1 -> [t, r], 2 -> [e], 3 - >[], 4 -> []]
     */
    public String frequencySort(String s) {

        Map<Character, Integer> freqs = new HashMap<>();

        for (Character c : s.toCharArray()) {
            freqs.put(c, freqs.getOrDefault(c, 0) + 1);
        }

        List<Character>[] buckets = new ArrayList[s.length() + 1];

        for (Map.Entry<Character, Integer> entry : freqs.entrySet()) {
            if (buckets[entry.getValue()] == null) {
                buckets[entry.getValue()] = new ArrayList<>();
            }

            buckets[entry.getValue()].add(entry.getKey());
        }

        StringBuilder sb = new StringBuilder();
        for (int i = buckets.length - 1; i >= 0; i--) {
            if (buckets[i] == null) {
                continue;
            }

            for (int j = 0; j < buckets[i].size(); j++) {
                char c = buckets[i].get(j);
                int count = 0;
                while (count < i) {
                    sb.append(c);
                    count++;
                }
            }
        }

        return sb.toString();
    }


    // solution 2 : PriorityQueue
    public String frequencySort2(String s) {

        Map<Character, Integer> map = new HashMap<>();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), 1);
            } else {
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            }
        }

        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>(
                (entry1, entry2) -> entry2.getValue() - entry1.getValue());

        pq.addAll(map.entrySet());

        while (!pq.isEmpty()) {
            Map.Entry e = pq.poll();
            for (int i = 0; i < (int) e.getValue(); i++) {
                sb.append(e.getKey());
            }
        }

        return sb.toString();
    }

}
