package com.jasper.math;

public class LC0050_Pow {

	public double myPow(double x, int n) {
		double res = power(x, Math.abs(n));

		if (n < 0) {
			return 1 / res;
		} else {
			return res;
		}

	}

	public double power(double x, int n) {

		if (n == 0) {
			return 1;
		}

		double v = power(x, n / 2);
		if (n % 2 == 0) {
			return v * v;
		} else {
			return v * v * x;
		}

	}

}
