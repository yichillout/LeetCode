package com.jasper.stack;

import java.util.*;

public class LC0496_NextGreaterElementI {

	/**
	 *
	 * @param findNums
	 * @param nums
	 * @return
	 *
	 * int[] nums1 = {4, 1, 2};
	 * int[] nums2 = {1, 3, 4, 2};
	 *
	 * [1 -> 3], [3 -> 4]
	 *
	 *
	 */

    // solution 1
    public static int[] nextGreaterElement1(int[] findNums, int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();

        for (int num : nums) {
            while (!stack.isEmpty() && stack.peek() < num) {
                map.put(stack.pop(), num);
            }
            stack.push(num);
        }

        for (int i = 0; i < findNums.length; i++) {
            if (map.containsKey(findNums[i])) {
                findNums[i] = map.get(findNums[i]);
            } else {
                findNums[i] = -1;
            }
        }

        return findNums;
    }

    // solution 2
    public int[] nextGreaterElement2(int[] nums1, int[] nums2) {

        int[] result = new int[nums1.length];

        for (int i = 0; i < nums1.length; i++) {
            int j = 0;
            while (j < nums2.length) {
                if (nums1[i] == nums2[j]) {
                    break;
                }
                j++;
            }

            for (int k = j + 1; k < nums2.length; k++) {
                if (nums1[i] < nums2[k]) {
                    result[i] = nums2[k];
                    break;
                }
            }

            if (result[i] == 0) {
                result[i] = -1;
            }
        }

        return result;
    }

    public static void main(String[] args) {

        int[] nums1 = {4, 1, 2};
        int[] nums2 = {1, 3, 4, 2};

        // [1 -> 3], [3 -> 4]

        int[] result = nextGreaterElement1(nums1, nums2);

    }

}
