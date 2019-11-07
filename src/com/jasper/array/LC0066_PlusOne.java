package com.jasper.array;

public class LC0066_PlusOne {

	public static int[] plusOne(int[] digits) {
		int k = 1;
		for (int i = digits.length - 1; i >= 0; i--) {
			digits[i] += k;
			k = digits[i] / 10;
			digits[i] %= 10;
		}

		if (k > 0) {
			int[] a = new int[digits.length + 1];
			a[0] = k;
			for (int i = 0; i < digits.length; i++) {
				a[i + 1] = digits[i];
			}
			return a;
		}
		return digits;
	}

}
