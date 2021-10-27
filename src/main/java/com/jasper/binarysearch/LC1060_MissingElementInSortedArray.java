package com.jasper.binarysearch;

public class LC1060_MissingElementInSortedArray {

    // solution 1 : binary search  O(logn)
    public int missingElement1(int[] nums, int k) {
        int n = nums.length;
        int l = 0;
        int h = n - 1;
        int missingNum = nums[n - 1] - nums[0] + 1 - n;

        if (missingNum < k) {
            return nums[n - 1] + k - missingNum; // nums[n - 1] + (k - missingNum);
        }

        while (l + 1 < h) {
            int m = l + (h - l) / 2;
            int missing = nums[m] - nums[l] + 1 - (m - l + 1);

            if (missing >= k) {
                // when the number is larger than k, then the index won't be located in (m, h]
                h = m;
            } else {
                // when the number is smaller than k, then the index won't be located in [l, m), update k -= missing
                k -= missing;
                l = m;
            }
        }

        return nums[l] + k;
    }

    // solution 2 : O(n)
    public int missingElement2(int[] arr, int k) {
        int j = 0;
        int count = 0;
        for (int i = arr[0]; i < arr[arr.length - 1]; i++) {
            if (i == arr[j]) {
                j++;
            } else {
                count++;
            }

            if (count == k) {
                return i;
            }
        }

        return arr[arr.length - 1] + k - count;
    }
}
