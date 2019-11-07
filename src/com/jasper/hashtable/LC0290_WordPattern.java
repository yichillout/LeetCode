package com.jasper.hashtable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LC0290_WordPattern {
	public boolean wordPattern(String pattern, String str) {

		char[] p = pattern.toCharArray();
		String[] s = str.split(" ");

		Map<Character, String> map = new HashMap<>();
		Set<String> set = new HashSet<>();

		if (p.length != s.length) {
			return false;
		}

		for (int i = 0; i < p.length; i++) {
			if (!map.containsKey(p[i])) {
				if (set.contains(s[i])) {
					return false;
				}
				map.put(p[i], s[i]);
				set.add(s[i]);
			} else {
				if (!s[i].equals(map.get(p[i]))) {
					return false;
				}
			}
		}

		return true;
	}
}
