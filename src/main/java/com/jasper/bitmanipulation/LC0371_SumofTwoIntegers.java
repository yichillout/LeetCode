package com.jasper.bitmanipulation;

public class LC0371_SumofTwoIntegers {

	// Solution 1 : iterative
	public int getSum1(int a, int b) {
		while (b != 0) {
			int carry = (a & b) << 1;
			a = a ^ b;
			b = carry;
		}
		return a;
	}

	// Solution 2 : recursion
	public int getSum2(int a, int b) {

		if (b == 0)
			return a;

		int sum = a ^ b;
		int carry = (a & b) << 1;

		return getSum2(sum, carry);

	}

}
