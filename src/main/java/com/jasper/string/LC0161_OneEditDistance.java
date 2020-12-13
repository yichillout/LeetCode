package com.jasper.string;

public class LC0161_OneEditDistance {

	public boolean isOneEditDistance(String s, String t) {

		int n = s.length();
		int m = t.length();

		if (Math.abs(m - n) > 1) {
			return false;
		}

		String longStr;
		String shortStr;

		if (n < m) {
			longStr = t;
			shortStr = s;
		} else {
			longStr = s;
			shortStr = t;
		}

		for (int i = 0; i < shortStr.length(); i++) {
			if (shortStr.charAt(i) != longStr.charAt(i)) {
				if (longStr.length() == shortStr.length()) {
					return longStr.substring(i + 1).equals(shortStr.substring(i + 1)); // just need to edit at index i
				} else {
					return longStr.substring(i + 1).equals(shortStr.substring(i)); // remove at index i of long string
				}
			}
		}

		return m != n; // long string just need to remove the last character
	}
}
