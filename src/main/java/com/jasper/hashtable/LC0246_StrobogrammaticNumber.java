package com.jasper.hashtable;

import java.util.*;

public class LC0246_StrobogrammaticNumber {

	public boolean isStrobogrammatic(String num) {

		if (num == null)
			return false;

		if (num.length() == 1 && !"180".contains(num))
			return false;

		Map<Character, Character> hm = new HashMap<Character, Character>();
		hm.put('1', '1');
		hm.put('0', '0');
		hm.put('8', '8');
		hm.put('6', '9');
		hm.put('9', '6');

		int lo = 0;
		int hi = num.length() - 1;

		while (lo <= hi) {
			if (hm.containsKey(num.charAt(lo))
					&& hm.get(num.charAt(lo)) == num.charAt(hi)) {
				lo++;
				hi--;
			} else {
				return false;
			}
		}

		return true;
	}
}
