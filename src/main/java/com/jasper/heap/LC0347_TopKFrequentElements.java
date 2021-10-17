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
    public int[] topKFrequent2(int[] nums, int k) {

        List<Integer> topKList = new ArrayList<>();

        Map<Integer, Integer> hm = new HashMap<>();
        List<Integer>[] freqs = new List[nums.length + 1];

        for (int i = 0; i < nums.length; i++) {
            hm.put(nums[i], hm.getOrDefault(nums[i], 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : hm.entrySet()) {
            if (freqs[entry.getValue()] == null) {
                freqs[entry.getValue()] = new ArrayList<>();
            }
            freqs[entry.getValue()].add(entry.getKey());
        }

        for (int i = freqs.length - 1; i >= 0; i--) {
            if (freqs[i] == null) {
                continue;
            }

            if (topKList.size() < k) {
                topKList.addAll(freqs[i]);
            }
        }

        int[] result = new int[topKList.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = topKList.get(i);
        }

        return result;
    }
}
