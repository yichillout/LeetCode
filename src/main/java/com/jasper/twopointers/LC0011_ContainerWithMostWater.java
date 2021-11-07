package com.jasper.twopointers;

public class LC0011_ContainerWithMostWater {

    public static int maxArea(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int max = 0;

        while (l < r) {
            int h = Math.min(height[l], height[r]);
            int width = r - l;
            if (h * width > max) {
                max = h * width;
            }

            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }

        return max;
    }

    public static void main(String[] args) {

        int[] nums = {3, 2, 5};
        System.out.println(maxArea(nums));

    }

}
