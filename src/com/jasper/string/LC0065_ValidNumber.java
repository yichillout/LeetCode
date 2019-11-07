package com.jasper.string;

public class LC0065_ValidNumber {
	public static boolean isNumber(String s) {

		int i = 0;
		int length = s.length();
		while (i < length && s.charAt(i) == ' ') {
			i++;
		}

		if (i < length && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
			i++;
		}

		boolean isNumber = false;
		while (i < length && Character.isDigit(s.charAt(i))) {
			i++;
			isNumber = true;
		}

		if (i < length && s.charAt(i) == '.') {
			i++;
			while (i < length && Character.isDigit(s.charAt(i))) {
				i++;
				isNumber = true;
			}
		}

		if (isNumber && i < length && s.charAt(i) == 'e') {
			i++;
			isNumber = false;
			if (i < length && (s.charAt(i) == '+' || s.charAt(i) == '-'))
				i++;

			while (i < length && Character.isDigit(s.charAt(i))) {
				i++;
				isNumber = true;
			}
		}
		while (i < length && Character.isWhitespace(s.charAt(i)))
			i++;
		return isNumber && i == length;

	}

	public static void main(String[] args) {
		System.out.println(isNumber("0.1"));
	}
}