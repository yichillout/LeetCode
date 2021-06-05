package com.jasper.design;

import java.util.*;

class WordDistance {

	Map<String, List<Integer>> hashMap;

	public WordDistance(String[] words) {

		hashMap = new HashMap<String, List<Integer>>();

		for (int i = 0; i < words.length; i++) {
			if (hashMap.containsKey(words[i])) {
				hashMap.get(words[i]).add(i);
			} else {
				List<Integer> list = new ArrayList<Integer>();
				list.add(i);
				hashMap.put(words[i], list);
			}
		}

	}

	public int shortest(String word1, String word2) {

		List<Integer> list1 = hashMap.get(word1);
		List<Integer> list2 = hashMap.get(word2);
		int result = Integer.MAX_VALUE;

		for (int i = 0; i < list1.size(); i++) {
			for (int j = 0; j < list2.size(); j++) {
				if (list1.get(i) < list2.get(j)) {
					if (result > (list2.get(j) - list1.get(i))) {
						result = list2.get(j) - list1.get(i);
					}
				} else {
					if (result > (list1.get(i) - list2.get(j))) {
						result = list1.get(i) - list2.get(j);
					}
				}
			}
		}

		return result;
	}
}

public class LC0244_ShortestWordDistanceII {

	public static void main(String[] args) {
		String[] words = { "practice", "makes", "perfect", "coding", "makes" };
		WordDistance wordDistance = new WordDistance(words);
		System.out.println(wordDistance.shortest("coding", "practice"));
		System.out.println(wordDistance.shortest("makes", "coding"));
	}
}
