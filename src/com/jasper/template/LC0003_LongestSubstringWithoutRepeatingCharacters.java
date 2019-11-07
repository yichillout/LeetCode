package com.jasper.template;

import java.util.*;

public class LC0003_LongestSubstringWithoutRepeatingCharacters {

	public int lengthOfLongestSubstring(String s) {

		int[] hash = new int[256];
		char[] cs = s.toCharArray();
		int result = 0;

		int j = 0;
		for (int i = 0; i < cs.length; i++) {
			hash[cs[i]]++;
			while (!can(hash)) {
				hash[cs[j]]--;
				j++;
			}
			result = Math.max(result, i - j + 1);
		}
		return result;
	}

	private boolean can(int[] hash) {
		for (int x : hash) {
			if (x > 1) {
				return false;
			}
		}
		return true;
	}
}
