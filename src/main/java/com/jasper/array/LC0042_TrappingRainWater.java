package com.jasper.array;

public class LC0042_TrappingRainWater {

    // solution 1
    public int trap1(int[] height) {
        int l = 0;
        int r = height.length - 1;

        int maxLeft = 0;
        int maxRight = 0;

        int sum = 0;
        while (l < r) {
            maxLeft = Math.max(height[l], maxLeft);
            maxRight = Math.max(height[r], maxRight);

            if (height[l] <= height[r]) {
                sum += maxLeft - height[l];
                l++;
            } else {
                sum += maxRight - height[r];
                r--;
            }
        }

        return sum;
    }

    // solution 2
    public int trap2(int[] height) {
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
