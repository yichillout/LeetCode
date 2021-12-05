package com.jasper.array;

public class LC0042_TrappingRainWater {

    public int trap(int[] height) {
        int[] left = new int[height.length];
        int[] right = new int[height.length];

        int max = 0;
        for (int i = 0; i < height.length; i++) {
            if (height[i] > max) {
                max = height[i];
            }
            left[i] = max;
        }

        max = 0;
        for (int i = height.length - 1; i >= 0; i--) {
            if (height[i] > max) {
                max = height[i];
            }
            right[i] = max;
        }

        int result = 0;
        for (int i = 1; i < height.length - 1; i++) {
            int diff = Math.min(left[i - 1], right[i + 1]) - height[i];
            result += diff > 0 ? diff : 0;
        }

        return result;
    }

}
