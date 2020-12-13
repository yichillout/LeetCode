package com.jasper.array;

import java.util.ArrayList;
import java.util.List;

public class LC1493_LongestSubarrayOf1sAfterDeletingOneElement {

    // solution 1
    public int longestSubarray1(int[] A) {
        int i = 0, j, k = 1;
        for (j = 0; j < A.length; ++j) {
            if (A[j] == 0) {
                k--;
            }
            if (k < 0 && A[i++] == 0) {
                k++;
            }
        }
        return j - i - 1;
    }

    // solution 2
    public int longestSubarray2(int[] nums) {
        List<Integer> list = new ArrayList<>();
        List<Integer> dlist = new ArrayList<>();

        int count = 0;
        int d = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                if (d > 0) {
                    dlist.add(d);
                }
                d = 0;
                count++;
                if (i == nums.length - 1) {
                    list.add(count);
                }
            } else {
                if (count > 0) {
                    list.add(count);
                    d = 0;
                }
                count = 0;
                if (list.size() > 0) {
                    d++;
                }
            }
        }

        if (list.size() == 0) {
            return 0;
        }


        if (list.size() == 1 && list.get(0) == nums.length) {
            return list.get(0) - 1;
        }

        int max = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) > max) {
                max = list.get(i);
            }
        }

        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) + list.get(i + 1) > max && dlist.get(i) == 1) {
                max = list.get(i) + list.get(i + 1);
            }
        }

        return max;
    }
}
