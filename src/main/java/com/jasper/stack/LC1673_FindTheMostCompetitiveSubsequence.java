package com.jasper.stack;

import java.util.Stack;

public class LC1673_FindTheMostCompetitiveSubsequence {


    /**
     * Before we do this,
     * we need to check if we still have enough elements after.
     * After we pop the last element from stack,
     * we have stack.size() - 1 in the stack,
     * there are A.size() - i can still be pushed.
     * if stack.size() - 1 + A.size() - i >= k, we can pop the stack.
     */
    public int[] mostCompetitive(int[] nums, int k) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[k];
        for (int i = 0; i < nums.length; i++) {
            while (!stack.empty() && nums[i] < nums[stack.peek()] && nums.length - i + stack.size() > k) {
                stack.pop();
            }
            if (stack.size() < k) {
                stack.push(i);
            }
        }

        for (int i = k - 1; i >= 0; i--) {
            result[i] = nums[stack.pop()];
        }

        return result;
    }
}
