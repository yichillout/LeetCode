package com.jasper.slidingwindow;

public class LC0424_LongestRepeatingCharacterReplacement {
	public int characterReplacement(String s, int k) {
		char[] chars = s.toCharArray();
		int[] count = new int[26];
		int result = 0;

		int j = 0;
		for (int i = 0; i < chars.length; i++) {
			count[chars[i] - 'A']++;
			while (!can(count, k)) {
				count[chars[j] - 'A']--;
				j++;
			}
			if (i - j + 1 > result) {
				result = i - j + 1;
			}

		}
		return result;
	}

	private boolean can(int[] count, int k) {
		int index = -1;
		int max = 0;
		int diff = 0;

		for (int i = 0; i < count.length; i++) {
			if (count[i] > max) {
				max = count[i];
				index = i;
			}
		}

		for (int i = 0; i < count.length; i++) {
			if (i != index) {
				diff += count[i];
			}
		}

		if (diff > k)
			return false;

		return true;
	}
}
