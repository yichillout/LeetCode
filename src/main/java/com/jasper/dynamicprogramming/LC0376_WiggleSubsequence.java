package com.jasper.dynamicprogramming;

public class LC0376_WiggleSubsequence {

    public int wiggleMaxLength(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int[] up = new int[nums.length];
        int[] down = new int[nums.length];

        up[0] = 1;
        down[0] = 1;

        for (int i = 1; i < nums.length; i++) {
            up[i] = 1;
            down[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if (up[i] < down[j] + 1) {
                        up[i] = down[j] + 1;
                    }
                } else if (nums[i] < nums[j]) {
                    if (down[i] < up[j] + 1) {
                        down[i] = up[j] + 1;
                    }
                }
            }
        }

        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (down[i] > max) {
                max = down[i];
            }
            if (up[i] > max) {
                max = up[i];
            }
        }

        return max;
    }
}
