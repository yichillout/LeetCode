package com.jasper.bitmanipulation;

/*
 [5, 7]：

 101　　110　　111

 [26, 30]：

 11010　　11011　　11100　　11101　　11110

 to find the part in common on the left side, we need to create the mask.

 1000000000000000000000000000000
 ...
 1000000000000000000000000000
 100000000000000000000000000
 ...

 */

public class LC0201_BitwiseANDofNumbersRange {

	public static int rangeBitwiseAnd(int m, int n) {
		int result = 0;

		for (int i = 30; i >= 0; i--) {
			int mask = 1 << i;
			System.out.println(Integer.toBinaryString(mask));
			if ((n & mask) == (m & mask)) {
				result = result | (mask & m);
			} else {
				break;
			}
		}

		return result;
	}

	public static void main(String[] args) {
		// 10:1010 11:1011 12:1100 13:1101
		System.out.println(rangeBitwiseAnd(10, 13));
	}
}
