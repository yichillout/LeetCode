package com.jasper.binarysearch;

public class LC0069_SqrtX {

    public int mySqrt(int x) {
        long l = 1;
        long r = x;

        while (l + 1 < r) {
            long mid = l + (r - l) / 2;
            if (mid * mid <= x) {
                l = mid;
            } else {
                r = mid;
            }
        }

        if (r * r <= x) {
            return (int) r;
        }

        return (int) l;
    }
}
