package com.jasper.math;

public class LC0007_ReverseInteger {

	public int reverse(int x) {

		int sign;
		long xTemp = x;

		if (xTemp < 0) {
			sign = -1;
		} else {
			sign = 1;
		}

		xTemp = Math.abs(xTemp);

		long temp = 0;

		while (xTemp != 0) {
			temp = temp * 10 + xTemp % 10;
			xTemp /= 10;
		}

		if (temp > Integer.MAX_VALUE) {
			return 0;
		}

		int result = (int) (sign * temp);

		return result;
	}

}
