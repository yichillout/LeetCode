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

	// Solution 1
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

	public List<Integer> topKFrequent2(int[] nums, int k) {

		List<Integer>[] bucket = new List[nums.length + 1];
		Map<Integer, Integer> frequencyMap = new HashMap<Integer, Integer>();

		for (int n : nums) {
			frequencyMap.put(n, frequencyMap.getOrDefault(n, 0) + 1);
		}

		for (int key : frequencyMap.keySet()) {
			int frequency = frequencyMap.get(key);
			if (bucket[frequency] == null) {
				bucket[frequency] = new ArrayList<>();
			}
			bucket[frequency].add(key);
		}

		List<Integer> res = new ArrayList<>();

		for (int pos = bucket.length - 1; pos >= 0 && res.size() < k; pos--) {
			if (bucket[pos] != null) {
				res.addAll(bucket[pos]);
			}
		}
		return res;
	}
}
