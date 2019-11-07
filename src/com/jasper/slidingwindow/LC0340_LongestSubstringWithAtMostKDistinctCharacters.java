package com.jasper.slidingwindow;

public class LC0340_LongestSubstringWithAtMostKDistinctCharacters {

	public int lengthOfLongestSubstringKDistinct(String s, int k) {

		int[] map = new int[256];
		int res = 0;

		int j = 0;
		for (int i = 0; i < s.length(); i++) {
			map[s.charAt(i)]++;
			while (!can(map, k)) {
				map[s.charAt(j)]--;
				j++;
			}

			if (res < (i - j + 1)) {
				res = i - j + 1;
			}
		}

		return res;
	}

	public boolean can(int[] map, int k) {
		int num = 0;
		for (int i = 0; i < map.length; i++) {
			if (map[i] > 0) {
				num++;
			}
			if (num > k)
				return false;
		}

		return true;
	}
}
