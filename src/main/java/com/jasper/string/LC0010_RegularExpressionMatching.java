package com.jasper.string;

public class LC0010_RegularExpressionMatching {

	// Dynamic Programming Solution
	// s: string to check    p:patterns
	// b* means both multiple b or zero b are valid
	
	public static boolean isMatch(String s, String p) {
		boolean[] match = new boolean[s.length() + 1];

		for (int i = 0; i < match.length; i++) {
			match[i] = false;
		}

		match[s.length()] = true;

		for (int i = p.length() - 1; i >= 0; i--) {
			if (p.charAt(i) == '*') {
				for (int j = s.length() - 1; j >= 0; j--) {
					match[j] = match[j] || match[j + 1] && (p.charAt(i - 1) == '.' || p.charAt(i - 1) == s.charAt(j));
				}
				i--;
			} else {
				for (int j = 0; j < s.length(); j++) {
					match[j] = match[j + 1] && (p.charAt(i) == '.' || p.charAt(i) == s.charAt(j));
				}
				match[s.length()] = false;
			}
		}

		return match[0];
	}

	public static void main(String[] args) {
		System.out.println(isMatch("abbc","ab*bbc"));
	}

}
