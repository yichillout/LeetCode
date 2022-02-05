package com.jasper.heap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class LC0347_TopKFrequentElements {

    class Item {
        int val;
        int freq;

        public Item(int val, int freq) {
            this.val = val;
            this.freq = freq;
        }
    }

    // Solution 1 : priority queue
    public List<Integer> topKFrequent1(int[] nums, int k) {

        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();

        PriorityQueue<Item> pq = new PriorityQueue<>(new Comparator<Item>() {
            public int compare(Item item1, Item item2) {
                return item2.freq - item1.freq;
            }
        });

        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], 1);
            } else {
                map.put(nums[i], map.get(nums[i]) + 1);
            }
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            pq.offer(new Item(entry.getKey(), entry.getValue()));
        }

        for (int i = 0; i < k; i++) {
            list.add(pq.poll().val);
        }

        return list;
    }


    // solution 2
    public List<String> topKFrequent(String[] words, int k) {

        List<String> res = new ArrayList<>();

        Map<String, Integer> freqs = new HashMap<>();

        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>((e1, e2) -> {
            if (e1.getValue() != e2.getValue()) {
                return e1.getValue() - e2.getValue();
            }

            return e2.getKey().compareTo(e1.getKey());
        });

        for (String word : words) {
            freqs.put(word, freqs.getOrDefault(word, 0) + 1);
        }

        for (Map.Entry<String, Integer> entry : freqs.entrySet()) {
            pq.offer(entry);

            if (pq.size() > k) {
                pq.poll();
            }
        }

        String[] resArray = new String[k];
        for (int i = resArray.length - 1; i >= 0; i--) {
            Map.Entry<String, Integer> entry = pq.poll();
            resArray[i] = entry.getKey();
        }


        for (String word : resArray) {
            res.add(word);
        }

        return res;
    }
}
