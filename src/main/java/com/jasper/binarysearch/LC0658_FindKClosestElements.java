package com.jasper.binarysearch;

import java.util.ArrayList;
import java.util.List;

public class LC0658_FindKClosestElements {

    // solution 1 : two pointer
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

    // solution 2 : binary search
    public List<Integer> kClosestNumbers(int[] arr, int k, int x) {
        int left = findLowerClosest(arr, x);
        int right = left + 1;

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            if (isLeftCloser(arr, x, left, right)) {
                result.add(arr[left]);
                left--;
            } else {
                result.add(arr[right]);
                right++;
            }
        }

        return result;
    }

    private boolean isLeftCloser(int[] arr, int target, int left, int right) {
        if (left < 0) {
            return false;
        }

        if (right >= arr.length) {
            return true;
        }

        int l = Math.abs(arr[left] - target);
        int r = Math.abs(arr[right] - target);

        return l <= r ? true : false;
    }

    private int findLowerClosest(int[] arr, int target) {
        // find the last element smaller than target
        int start = 0;
        int end = arr.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == target) {
                end = mid;
            } else if (arr[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }

        if (arr[end] < target) {
            return end;
        }
        if (arr[start] < target) {
            return start;
        }

        return -1;
    }

}
