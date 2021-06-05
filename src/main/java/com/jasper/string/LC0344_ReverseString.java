package com.jasper.string;

public class LC0344_ReverseString {

	public String reverseString(String s) {

		int lo = 0;
		int hi = s.length() - 1;
		char[] charArray = s.toCharArray();

		while (lo < hi) {
			char temp = charArray[lo];
			charArray[lo] = charArray[hi];
			charArray[hi] = temp;
			lo++;
			hi--;
		}

		return String.valueOf(charArray);

	}

}
