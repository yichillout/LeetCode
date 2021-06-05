package com.jasper.slidingwindow;

import java.util.HashMap;

public class LC0076_MinimumWindowSubstring {

	public static String minWindow(String s, String t) {

		int[] count = new int[256];
		int minLen = Integer.MAX_VALUE;
		String str = "";

		for (int i = 0; i < t.length(); i++) {
			count[t.charAt(i)]++;
		}

		int j = 0;
		for (int i = 0; i < s.length(); i++) {
			count[s.charAt(i)]--;
			while (can(count)) {
				// System.out.println("j:" + j + "i:" + i + "; srt = " + s.substring(j, i + 1));
				if (i - j + 1 < minLen) {
					str = s.substring(j, i + 1);
					minLen = i - j + 1;
				}
				count[s.charAt(j)]++;
				j++;
			}
		}

		return str;
	}

	private static boolean can(int[] count) {
		for (int i = 0; i < count.length; i++) {
			if (count[i] > 0) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(minWindow("ADOBECODEBANC", "ABC"));
	}
}