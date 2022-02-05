package com.jasper.math;

public class LC0007_ReverseInteger {

    // solution 1
    public int reverse1(int x) {
        int rev = 0;

        /**
         *
         * Integer.MAX_VALUE      =  2147483647
         * Integer.MAX_VALUE / 10 =   214748364  (rev = 214748365 > 214748364 ==> 2147483650 > 2147483647)
         * Integer.MAX_VALUE % 10 =           7
         * Integer.MIN_VALUE      = -2147483648
         * Integer.MIN_VALUE / 10 =  -214748364 (rev = -214748363 < -214748364 ==> -2147483630 < -2147483648)
         * Integer.MIN_VALUE % 10 =          -8
         *
         */


        //                      1534236469

        while (x != 0) {
            int num = x % 10;
            x /= 10;

            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && num > 7)) {
                return 0;
            }

            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && num < -8)) {
                return 0;
            }

            rev = rev * 10 + num;
        }

        return rev;
    }

    // solution 2 : use long
    public int reverse2(int x) {

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
