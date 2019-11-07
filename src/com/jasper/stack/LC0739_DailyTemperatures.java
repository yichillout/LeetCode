package com.jasper.stack;

import java.util.Stack;

public class LC0739_DailyTemperatures {

	// Time: O(N)
	// Space: O(N)
	public int[] dailyTemperatures(int[] T) {

		Stack<Integer> stack = new Stack<>();

		if (T == null || T.length == 0) {
			return new int[0];
		}

		stack.push(0);

		int[] result = new int[T.length];

		for (int i = 1; i < T.length; i++) {
			while (!stack.isEmpty() && T[i] > T[stack.peek()]) {
				int index = stack.pop();
				result[index] = i - index;
			}
			stack.push(i);
		}

		while (!stack.isEmpty()) {
			result[stack.pop()] = 0;
		}

		return result;
	}
}
