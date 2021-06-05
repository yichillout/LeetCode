package com.jasper.slidingwindow;

import com.annotation.Template;

import java.util.*;

@Template
public class LC0003_LongestSubstringWithoutRepeatingCharacters {

	// Solution 1
	public int lengthOfLongestSubstring1(String s) {

		if (s.length() == 0) {
			return s.length();
		}

		Map<Character, Integer> map = new HashMap<>();

		char[] ss = s.toCharArray();
		int j = 0;
		int res = 0;
		for (int i = 0; i < ss.length; i++) {
			if (map.containsKey(ss[i])) {
				int index = map.get(ss[i]);
				if (index + 1 >= j) {
					j = index + 1;
				}
			}
			map.put(ss[i], i);
			if (i - j + 1 > res) {
				res = i - j + 1;
			}
		}
		return res;
	}

	// Solution 2
	public int lengthOfLongestSubstring2(String s) {

		int result = 0;
		int[] counter = new int[256];
		char[] chars = s.toCharArray();

		int j = 0;
		for (int i = 0; i < chars.length; i++) {
			counter[chars[i]]++;
			while (isRepeated(counter)) {
				counter[chars[j]]--;
				j++;
			}
			result = Math.max(result, i - j + 1);
		}

		return result;
	}

	public boolean isRepeated(int[] counter) {
		for (int i = 0; i < counter.length; i++) {
			if (counter[i] > 1) {
				return true;
			}
		}
		return false;
	}
}
