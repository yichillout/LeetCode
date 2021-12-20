package com.jasper.string;

import java.util.Stack;

public class LC0032_LongestValidParentheses {

    // Solution 1 : stack
    public static int longestValidParentheses1(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);

        int max = 0;
        char[] ss = s.toCharArray();

        for (int i = 0; i < ss.length; i++) {
            if (ss[i] == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    max = Math.max(max, i - stack.peek());
                }
            }
        }

        return max;
    }

    // Solution 2 : DP
    public static int longestValidParentheses2(String s) {
        if (s.length() == 0) {
            return 0;
        }

        int maxLen = 0;
        int[] d = new int[s.length()];

        // d[i] means max valid length starts with i
        d[s.length() - 1] = 0;

        for (int i = s.length() - 2; i >= 0; i--) {
            if (s.charAt(i) == ')') {
                d[i] = 0;
            } else {
                int j = (i + 1) + d[i + 1];

                if (j < s.length() && s.charAt(j) == ')') {
                    d[i] = d[i + 1] + 2;

                    if (j + 1 < s.length())
                        d[i] += d[j + 1];

                } else {
                    d[i] = 0;
                }

            }

            maxLen = Math.max(maxLen, d[i]);
        }

        return maxLen;
    }


    public static void main(String[] args) {
        System.out.println(longestValidParentheses1("()(()"));
    }

}
