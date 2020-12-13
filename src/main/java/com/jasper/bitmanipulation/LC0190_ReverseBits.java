package com.jasper.bitmanipulation;

public class LC0190_ReverseBits {

	// you need treat n as an unsigned value
	public int reverseBits(int n) {

		int result = 0;
		for (int i = 0; i < 32; i++) {
			int temp = n & 1;
			int tempReverse = temp << (31 - i);
			result |= tempReverse;
			n >>>= 1;
		}

		return result;

	}

}
