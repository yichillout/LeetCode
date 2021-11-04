package com.jasper.binarysearch;

public class LC1011_CapacityToShipPackagesWithinDDays {

    public int shipWithinDays(int[] weights, int days) {

        int sum = 0;
        int max = Integer.MIN_VALUE;
        for (int weight : weights) {
            sum += weight;
            if (weight > max) {
                max = weight;
            }
        }

        int l = max;
        int r = sum;

        while (l + 1 < r) {
            int mid = l + (r - l) / 2;
            if (isValid(weights, mid, days)) {
                r = mid;
            } else {
                l = mid;
            }
        }

        if (isValid(weights, l, days)) {
            return l;
        }

        return r;
    }

    public boolean isValid(int[] weights, int capacity, int days) {

        int cur = 0;
        for (int i = 0; i < weights.length; i++) {
            cur += weights[i];

            if (cur == capacity) {
                cur = 0;
                days--;
            } else if (cur > capacity) {
                cur = weights[i];
                days--;
            }
        }

        if (cur > 0) {
            days--;
        }

        return days >= 0;
    }
}
