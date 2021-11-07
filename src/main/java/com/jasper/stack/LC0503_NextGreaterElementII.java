package com.jasper.stack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class LC0503_NextGreaterElementII {

    // Solution 1 O(n^2)
    public int[] nextGreaterElements1(int[] nums) {
        int[] result = new int[nums.length];

        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            if (num > max) {
                max = num;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            result[i] = findNext(nums, i, max);
        }

        return result;
    }

    public int findNext(int[] nums, int index, int max) {
        if (nums[index] == max) {
            return -1;
        }

        int i = (index + 1) % nums.length;
        while (nums[i] <= nums[index]) {
            i++;
            i %= nums.length;
        }

        return nums[i];
    }

    // Solution 2 O(n)
    public static int[] nextGreaterElements2(int[] nums) {

        Stack<Integer> stack = new Stack<>();
        int n = nums.length;
        int[] result = new int[n];
        Arrays.fill(result, -1);


        for (int i = 0; i < n * 2; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i % n]) {
                result[stack.pop()] = nums[i % n];
            }
            stack.push(i % n);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 1, 4, 3};
        int[] result = nextGreaterElements2(nums);

    }

}
