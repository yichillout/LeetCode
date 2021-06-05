package com.jasper.string;

/*
   B A N A A N A S
   B A * N A * ? S
*/

public class LC0044_WildcardMatching {
	public static boolean isMatch(String s, String p) {
		int i = 0;
		int j = 0;
		int smark = -1;
		int pmark = -1;

		while (i < s.length()) {
			if (j < p.length()
					&& (p.charAt(j) == '?' || p.charAt(j) == s.charAt(i))) {
				++i;
				++j;
			} else if (j < p.length() && p.charAt(j) == '*') {
				smark = i;
				pmark = j; // only when p.charAt(j) == '*', the pmark will be changed to j
				j++;
			} else if (pmark != -1) {
				smark = smark + 1;
				i = smark;
				j = pmark + 1;
			} else {
				return false;
			}
		}
		while (j < p.length() && p.charAt(j) == '*') {
			++j;
		}
		return j == p.length();
	}
}
