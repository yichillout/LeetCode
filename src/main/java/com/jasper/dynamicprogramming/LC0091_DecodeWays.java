package com.jasper.dynamicprogramming;

public class LC0091_DecodeWays {

	public int numDecodings(String s) {

		char[] ss = s.toCharArray();

		int[] f = new int[ss.length + 1];

		f[0] = 1;

		for (int i = 1; i < f.length; i++) {

			f[i] = 0;

			int num1 = ss[i - 1] - '0';
			if (num1 >= 1 && num1 <= 9) {
				f[i] += f[i - 1];
			}

			if (i > 1) {
				int num2 = ss[i - 1] - '0' + (ss[i - 2] - '0') * 10;
				if (num2 >= 10 && num2 <= 26) {
					f[i] += f[i - 2];
				}
			}
		}

		return f[f.length - 1];
	}

}
