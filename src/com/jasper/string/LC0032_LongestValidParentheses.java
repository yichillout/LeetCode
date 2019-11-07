package com.jasper.string;

import java.util.Stack;

public class LC0032_LongestValidParentheses {

	// Solution 1 : DP
	public static int longestValidParentheses1(String s) {
		if (s.length() == 0)
			return 0;

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

				} else
					d[i] = 0;

			}
			maxLen = Math.max(maxLen, d[i]);

		}
		return maxLen;
	}

	// Solution 2 : stack
	public int longestValidParentheses2(String s) {

		Stack<Integer> stack = new Stack<>();
		stack.push(-1);

		char[] ss = s.toCharArray();

		int res = 0;
		for (int i = 0; i < ss.length; i++) {
			if (ss[i] == '(' || ss[i] == '{' || ss[i] == '[') {
				stack.push(i);
			} else {
				if (stack.size() == 1) {
					stack.push(i);
				} else {
					char c = ss[stack.peek()];
					int len = 0;
					if ((ss[i] == ')' && c == '(') || (ss[i] == '}' && c == '{') || (ss[i] == ']' && c == '[')) {
						stack.pop();
						len = i - stack.peek();
					} else {
						stack.push(i);
					}
					if (len > res) {
						res = len;
					}
				}
			}
		}
		return res;
	}

	public static void main(String[] args) {
		System.out.println(longestValidParentheses1(")()())"));
	}

}
