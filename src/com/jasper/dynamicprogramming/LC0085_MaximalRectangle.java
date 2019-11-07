package com.jasper.dynamicprogramming;

import java.util.Stack;

public class LC0085_MaximalRectangle {
	
	public static int maximalRectangle(char[][] matrix) {

		int max = 0;

		if (matrix.length == 0)
			return 0;

		int[] heights = new int[matrix[0].length];

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] == '0') {
					heights[j] = 0;
				} else {
					heights[j] = heights[j] + 1;
				}
			}
			if (max < largestRectangleArea(heights)) {
				max = largestRectangleArea(heights);
			}
		}
		return max;
	}

	public static int largestRectangleArea(int[] height) {
		if (height == null || height.length == 0) {
			return 0;
		}

		Stack<Integer> stack = new Stack<Integer>();

		int max = 0;
		int i = 0;

		while (i < height.length) {
			// push index to stack when the current height is larger than the
			// previous one
			if (stack.isEmpty() || height[i] >= height[stack.peek()]) {
				stack.push(i);
				i++;
			} else {
				// calculate max value when the current height is less than the
				// previous one
				int p = stack.pop();
				int h = height[p];
				int w = stack.isEmpty() ? i : i - stack.peek() - 1;
				max = Math.max(h * w, max);
			}

		}

		while (!stack.isEmpty()) {
			int p = stack.pop();
			int h = height[p];
			int w = stack.isEmpty() ? i : i - stack.peek() - 1;
			max = Math.max(h * w, max);
		}

		return max;
	}

	public static void main(String[] args) {

		char[][] matrix = { { '1', '0', '1', '0', '0' },
							{ '1', '0', '1', '1', '1' }, 
							{ '1', '1', '1', '1', '1' },
							{ '1', '0', '0', '1', '0' } };

		// char[][] matrix = {};
		System.out.println(maximalRectangle(matrix));
	}
}
