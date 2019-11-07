package com.jasper.math;

public class LC0012_IntegerToRoman {

	public String intToRoman(int num) {

		StringBuilder result = new StringBuilder();
		String[] symbol = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
		int[] value = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };

		int index = 0;

		while (num != 0) {
			while (num >= value[index]) {
				num -= value[index];
				result.append(symbol[index]);
			}
			index++;
		}

		return result.toString();
	}
}
