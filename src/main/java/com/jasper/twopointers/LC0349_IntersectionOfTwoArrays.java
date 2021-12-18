package com.jasper.twopointers;

import java.util.*;

public class LC0349_IntersectionOfTwoArrays {

    // solution 1 : sort + two pointer
    public int[] intersection1(int[] nums1, int[] nums2) {
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

                while (index1 < nums1.length && nums1[index1 - 1] == nums1[index1]) {
                    index1++;
                }

                while (index2 < nums2.length && nums2[index2 - 1] == nums2[index2]) {
                    index2++;
                }
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

    // solution 2 : set
    public int[] intersection2(int[] nums1, int[] nums2) {
        Set<Integer> resultSet = new HashSet<>();
        Set<Integer> set1 = new HashSet<>();

        for (int n1 : nums1) {
            set1.add(n1);
        }

        for (int i = 0; i < nums2.length; i++) {
            if (set1.contains(nums2[i])) {
                resultSet.add(nums2[i]);
            }
        }

        int[] result = new int[resultSet.size()];

        int index = 0;
        for (int num : resultSet) {
            result[index++] = num;
        }

        return result;
    }

    // solution 3 : binary search
    public int[] intersection3(int[] nums1, int[] nums2) {
        Set<Integer> resultSet = new HashSet<>();

        Arrays.sort(nums2);

        for (int i = 0; i < nums1.length; i++) {
            if (binarySearch(nums2, nums1[i])) {
                resultSet.add(nums1[i]);
            }
        }

        int[] result = new int[resultSet.size()];

        int index = 0;
        for (int num : resultSet) {
            result[index++] = num;
        }

        return result;
    }

    public boolean binarySearch(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l + 1 < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] <= target) {
                l = mid;
            } else {
                r = mid;
            }
        }

        if (nums[l] == target || nums[r] == target) {
            return true;
        }

        return false;
    }
}
