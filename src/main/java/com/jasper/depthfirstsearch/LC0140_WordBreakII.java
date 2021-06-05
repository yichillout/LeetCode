package com.jasper.depthfirstsearch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC0140_WordBreakII {

	public List<String> wordBreak(String s, List<String> wordDict) {
		Map<String, List<String>> memo = new HashMap<>();
		return helper(wordDict, s, memo);
	}

	private List<String> helper(List<String> wordDict, String s, Map<String, List<String>> memo) {
		if (memo.containsKey(s)) {
			return memo.get(s);
		}

		List<String> buffer = new ArrayList<>();

		if (wordDict.contains(s)) {
			buffer.add(s);
		}

		for (int i = 1; i < s.length(); i++) {
			String s1 = s.substring(0, i);
			String s2 = s.substring(i);
			if (wordDict.contains(s1)) {
				List<String> strList = helper(wordDict, s2, memo);
				for (String str : strList) {
					buffer.add(s1 + " " + str);
				}
			}
		}

		memo.put(s, buffer);
		return buffer;
	}

}
