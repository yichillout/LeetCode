package com.jasper.binarysearch;

public class LC1011_CapacityToShipPackagesWithinDDays {

    public int shipWithinDays(int[] weights, int days) {
        int sum = 0;
        int max = 0;
        for(int weight : weights) {
            sum += weight;
            max = Math.max(max, weight);
        }

        return binarySearch(weights, days, max, sum);
    }

    public int binarySearch(int[] weights, int days, int low, int high) {
        int l = low;
        int r = high;

        while(l + 1 < r) {
            int mid = l + (r - l) / 2;
            if(isValid(weights, days, mid)) {
                r = mid;
            } else {
                l = mid;
            }
        }

        return isValid(weights, days, l) ? l : r;
    }

    public boolean isValid(int[] weights, int days, int target) {
        int cur = 0;
        int count = 1;

        for(int num : weights) {
            if(cur + num <= target) {
                cur += num;
            } else {
                count++;
                cur = num;
                if(count > days) {
                    return false;
                }
            }
        }

        return true;
    }
}
