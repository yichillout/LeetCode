package com.jasper.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class LC0503_NextGreaterElementII {

	// Solution 1 O(n^2)
	public static int[] nextGreaterElements1(int[] nums) {

		int[] result = new int[nums.length];

		for (int i = 0; i < nums.length; i++) {
			result[i] = -1;
			for (int j = 1; j < nums.length; j++) {
				if (nums[(i + j) % nums.length] > nums[i]) {
					result[i] = nums[(i + j) % nums.length];
					break;
				}
			}
		}
		return result;
	}

	// Solution 2 O(n)
	public static int[] nextGreaterElements2(int[] nums) {
		
		//  top           3(9)
		//                4(8)
		//           1(7) 4(8)
        //           2(6)
		
		int[] res = new int[nums.length];
		Stack<Integer> stack = new Stack<>();
		for (int i = 2 * nums.length - 1; i >= 0; --i) {
			while (!stack.empty() && nums[stack.peek()] <= nums[i % nums.length]) {
				stack.pop();
			}
			res[i % nums.length] = stack.empty() ? -1 : nums[stack.peek()];
			stack.push(i % nums.length);
		}
		return res;
	}

	public static void main(String[] args) {

		int[] nums = { 1, 2, 1, 4, 3 };

		int[] result = nextGreaterElements2(nums);

	}

}
