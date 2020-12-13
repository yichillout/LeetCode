package com.jasper.math;

import java.util.*;

public class LC0013_RomantoInteger {

	public int romanToInt(String s) {

		Map<Character, Integer> map = new HashMap<>();
		map.put('I', 1);
		map.put('V', 5);
		map.put('X', 10);
		map.put('L', 50);
		map.put('C', 100);
		map.put('D', 500);
		map.put('M', 1000);

		if (s == null || s.length() == 0) {
			return 0;
		}

		char[] ss = s.toCharArray();
		int n = ss.length;

		int res = 0;
		res += map.get(ss[n - 1]);

		for (int i = n - 2; i >= 0; i--) {
			System.out.println(res);
			if (map.get(ss[i + 1]) > map.get(ss[i])) {
				res -= map.get(ss[i]);
			} else {
				res += map.get(ss[i]);
			}
		}

		return res;
	}
}
