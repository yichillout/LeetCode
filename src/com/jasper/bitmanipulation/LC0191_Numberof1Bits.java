package com.jasper.bitmanipulation;

public class LC0191_Numberof1Bits {

	// you need to treat n as an unsigned value
	public int hammingWeight(int n) {
		int count = 0;
		while (n != 0) {
			n = n & (n - 1);
			count++;
		}
		return count;
	}

}
