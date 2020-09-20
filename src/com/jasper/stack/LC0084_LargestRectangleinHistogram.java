package com.jasper.stack;

import com.annotation.Template;

import java.util.Stack;

@Template
public class LC0084_LargestRectangleinHistogram {

    // solution 1
    public int largestRectangleArea01(int[] heights) {
        int result = 0;

        for (int i = 0; i < heights.length; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = i; j < heights.length; j++) {
                if (min > heights[j]) {
                    min = heights[j];
                }

                int a = min * (j - i + 1);

                if (result < a) {
                    result = a;
                }
            }
        }

        return result;
    }


    /**
     * 单调栈的运用： 找左边和右边第一个比它大的元素
     *
     * 思路： 以每个柱子的高度，向左和向右最多能延伸多少。
     *
     * 当进去栈的数字比栈顶小的时候，证明里面的柱子是时候要计算最
     * 大面积了，因为右边第一个比它们小的已经找到了。 而左边第一个比它小的就
     * 是栈里面的下一个
     *
     *
     * stack
     * 2
     * 1, 5       ==> calculate 2 : (2 * 1) => 2
     * 1, 5, 6
     * 1, 2       ==> calculate 6, 5 : (6 * (4 - 2 - 1)) => 6, (5 * (4 - 1 - 1)) => 10
     * 1, 2, 3
     *            ==> calculate 3, 2, 1 : (3 * (6 - 2 - 1)) => 6, (5 * (4 - 1 - 1)) => 10
     *
     * stack index
     * 0
     * 1, 2
     * 1, 2, 3
     * 1, 4
     * 1, 4, 5
     */

    // solution 2
    public static int largestRectangleArea02(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }

        Stack<Integer> stack = new Stack<>();

        int max = 0;
        int i = 0;

        while (i < height.length) {
            if (stack.isEmpty() || height[i] >= height[stack.peek()]) {
                stack.push(i);
                i++;
            } else {
                int h = height[stack.pop()];
                int w = stack.isEmpty() ? i : i - stack.peek() - 1;
                max = Math.max(h * w, max);
            }

        }

        while (!stack.isEmpty()) {
            int h = height[stack.pop()];
            int w = stack.isEmpty() ? i : i - stack.peek() - 1;
            max = Math.max(h * w, max);
        }

        return max;
    }

    public static void main(String[] args) {
        int[] heights = {2, 1, 5, 6, 2, 3};
        System.out.println(largestRectangleArea02(heights));
    }

}
