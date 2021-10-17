package com.jasper.heap;

import java.util.*;

public class LC0451_SortCharactersByFrequency {

    // solution 1 : Bucket sort
    public String frequencySort(String s) {
        Map<Character, Integer> frequencyForNum = new HashMap<>();

        for (char c : s.toCharArray()) {
            frequencyForNum.put(c, frequencyForNum.getOrDefault(c, 0) + 1);
        }


        List<Character>[] frequencyBucket = new ArrayList[s.length() + 1];

        for (char c : frequencyForNum.keySet()) {
            int f = frequencyForNum.get(c);
            if (frequencyBucket[f] == null) {
                frequencyBucket[f] = new ArrayList<>();
            }
            frequencyBucket[f].add(c);
        }

        StringBuilder str = new StringBuilder();

        for (int i = frequencyBucket.length - 1; i >= 0; i--) {
            if (frequencyBucket[i] == null) {
                continue;
            }

            for (char c : frequencyBucket[i]) {
                for (int j = 0; j < i; j++) {
                    str.append(c);
                }
            }
        }

        return str.toString();
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
