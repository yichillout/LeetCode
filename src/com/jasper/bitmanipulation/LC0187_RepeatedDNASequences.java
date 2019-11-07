package com.jasper.bitmanipulation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LC0187_RepeatedDNASequences {

	public static List<String> findRepeatedDnaSequences(String s) {

		List<String> ans = new ArrayList<String>();
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int key = 0;
		for (int i = 0; i < s.length(); i++) {
			key = ((key << 3) | (s.charAt(i) & 0x7)) & 0x3fffffff;
			System.out.println(Integer.toBinaryString(key));
			if (i < 9)
				continue;
			if (map.get(key) == null) {
				map.put(key, 1);
			} else if (map.get(key) == 1) {
				ans.add(s.substring(i - 9, i + 1));
				map.put(key, 2);
			}
		}

		return ans;
	}

	public static void main(String[] args) {
		ArrayList array = (ArrayList) findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT");
	}

}
