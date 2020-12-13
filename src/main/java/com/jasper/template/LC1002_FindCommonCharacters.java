package com.jasper.template;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC1002_FindCommonCharacters {

	public List<String> commonChars(String[] A) {

		List<String> results = new ArrayList<>();

		int[] minCount = new int[26];

		for (int i = 0; i < minCount.length; i++) {
			minCount[i] = Integer.MAX_VALUE;
		}

		for (String w : A) {
			int[] count = new int[26];
			for (char c : w.toCharArray()) {
				count[c - 'a']++;
			}
			for (int i = 0; i < minCount.length; i++) {
				minCount[i] = Math.min(minCount[i], count[i]);
			}
		}

		for (int i = 0; i < minCount.length; i++) {
			for (int j = 0; j < minCount[i]; j++) {
				results.add("" + (char) (i + 'a'));
			}
		}
		return results;
	}
}
