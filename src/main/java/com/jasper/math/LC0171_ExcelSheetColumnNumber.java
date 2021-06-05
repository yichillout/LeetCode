package com.jasper.math;

public class LC0171_ExcelSheetColumnNumber {

	public int titleToNumber(String s) {

		if (s == null || s.length() == 0)
			return 0;

		int n = s.length() - 1;
		int k = 1;
		int res = 0;
		for (int i = n; i >= 0; i--) {
			char c = s.charAt(i);
			res += k * (c - 'A' + 1);
			k *= 26;
		}

		return res;
	}

}
