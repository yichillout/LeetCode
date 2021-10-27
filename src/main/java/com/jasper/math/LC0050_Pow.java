package com.jasper.math;

public class LC0050_Pow {

    // solution 1 : recursion
    public double myPow1(double x, int n) {
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

    // solution 2 : iteration
    public double myPow2(double x, int n) {
        if (n == 0) {
            return 1.0;
        }

        if (n < 0) {
            x = 1 / x;
            n = -n;
        }

        double result = 1.0;

        int i = n;

        while (i != 0) {
            if (i % 2 != 0) {
                result *= x;
            }
            i /= 2;
            x *= x;
        }

        return result;
    }
}
