package com.jasper.math;

public class LC0168_ExcelSheetColumnTitle {

	public static String convertToTitle(int n) {
		if (n <= 0)
			return "";
		StringBuilder result = new StringBuilder();

		while (n > 0) {
			if (n % 26 == 0) { // n is multiple of 26, example - 52 - 'AZ'
				result.insert(0, 'Z');
				n = n / 26 - 1;
			} else {
				int c = 'A' + n % 26 - 1; // example - 27 - 'AA'
				result.insert(0, (char) c);
				n /= 26;
			}
		}

		return result.toString();
	}

	public static void main(String[] args) {
		System.out.println(convertToTitle(27));
	}
}
