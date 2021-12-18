package com.jasper.twopointers;

import java.util.*;

public class LC0350_IntersectionOfTwoArraysII {

    // solution 1 : two pointers
    public int[] intersect1(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int index1 = 0;
        int index2 = 0;

        List<Integer> result = new ArrayList<>();

        while (index1 < nums1.length && index2 < nums2.length) {
            if (nums1[index1] == nums2[index2]) {
                result.add(nums1[index1]);
                index1++;
                index2++;
            } else if (nums1[index1] < nums2[index2]) {
                index1++;
            } else {
                index2++;
            }
        }

        int[] res = new int[result.size()];

        for (int i = 0; i < res.length; i++) {
            res[i] = result.get(i);
        }

        return res;
    }

    // solution 2 : HashMap
    public int[] intersect2(int[] nums1, int[] nums2) {
        List<Integer> resultList = new ArrayList<>();

        Map<Integer, Integer> hm = new HashMap<>();

        for (int num : nums1) {
            hm.put(num, hm.getOrDefault(num, 0) + 1);
        }

        for (int num : nums2) {
            if (hm.getOrDefault(num, 0) > 0) {
                resultList.add(num);
                hm.put(num, hm.getOrDefault(num, 0) - 1);
            }
        }

        int[] result = new int[resultList.size()];

        int index = 0;
        for (int num : resultList) {
            result[index++] = num;
        }

        return result;
    }
}
