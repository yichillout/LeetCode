package com.jasper.dynamicprogramming;

import java.util.*;

public class LC0139_WordBreak {

	// 0 1 2 3 4 5 6 7 8
    // t       t       t --- i    	
	//   l e e t c o d e
	//   0 1 2 3 4 5 6 7 --- j

	public static boolean wordBreak(String s, List<String> wordDict) {

		if (s == null || wordDict == null || wordDict.size() == 0) {
			return false;
		}

		boolean[] match = new boolean[s.length() + 1];

		match[0] = true;

		for (int i = 1; i <= s.length(); i++) {
			for (int j = 0; j < i; j++) {
				// 在这里match[j]刚刚好就是之前的那个时候能match
				if (match[j] && wordDict.contains(s.substring(j, i))) { 
					match[i] = true;
				}
			}
		}

		return match[s.length()];
	}

	public static void main(String[] args) {
		String s = "leetcode";
		List<String> dict = new ArrayList<String>();
		dict.add("leet");
		dict.add("code");
		System.out.println(wordBreak(s, dict));
	}
}
