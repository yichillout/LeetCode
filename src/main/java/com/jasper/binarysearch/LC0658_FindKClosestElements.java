package com.jasper.binarysearch;

import java.util.ArrayList;
import java.util.List;

public class LC0658_FindKClosestElements {

    // solution 1:
    public List<Integer> findClosestElements1(int[] arr, int k, int x) {

        int l = 0;
        int r = arr.length - 1;
        List<Integer> res = new ArrayList<>();

        while (r - l + 1 > k) {
            if (Math.abs(arr[l] - x) <= Math.abs(arr[r] - x)) {
                r--;
            } else {
                l++;
            }
        }

        for (int i = l; i <= r; i++) {
            res.add(arr[i]);
        }

        return res;
    }
}
