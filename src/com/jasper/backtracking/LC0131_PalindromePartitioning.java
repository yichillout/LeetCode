package com.jasper.backtracking;

import java.util.*;

public class LC0131_PalindromePartitioning {

	public static List<List<String>> partition(String s) {
		List<List<String>> res = new ArrayList<>();
		List<String> list = new ArrayList<>();
		partition(res, list, s);
		return res;
	}

	private static void partition(List<List<String>> res, List<String> list, String s) {

		if (s == null || s.length() == 0) {
			res.add(new ArrayList<String>(list));
			return;
		}

		for (int i = 0; i < s.length(); i++) {
			String subStr = s.substring(0, i + 1);
			if (isPalindrome(subStr)) {
				list.add(subStr);
				partition(res, list, s.substring(i + 1));
				list.remove(list.size() - 1);
			}
		}

	}

	private static boolean isPalindrome(String s) {
		if (s == null || s.length() < 2) {
			return true;
		}
		int lo = 0, hi = s.length() - 1;
		while (lo <= hi) {
			if (s.charAt(lo) != s.charAt(hi)) {
				return false;
			}
			lo++;
			hi--;
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(partition("aaab"));
	}

}