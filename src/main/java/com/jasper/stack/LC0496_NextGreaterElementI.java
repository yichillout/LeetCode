package com.jasper.stack;

import java.util.*;

public class LC0496_NextGreaterElementI {

	public static int[] nextGreaterElement(int[] findNums, int[] nums) {

		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		Stack<Integer> stack = new Stack<Integer>();

		for (int num : nums) {
			while (!stack.isEmpty() && stack.peek() < num)
				map.put(stack.pop(), num);
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

	public static void main(String[] args) {

		int[] nums1 = { 4, 1, 2 };
		int[] nums2 = { 1, 3, 4, 2 };

		int[] result = nextGreaterElement(nums1, nums2);

	}

}
