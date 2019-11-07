package com.jasper.array;

public class LC0011_ContainerWithMostWater {
	
	public int maxArea(int[] height) {

		int left = 0;
		int right = height.length - 1;
		int result = 0;

		while (left < right) {
			int leftHeight = height[left];
			int rightHeight = height[right];
			int tmp = (right - left) * Math.min(leftHeight, rightHeight);

			if (tmp > result) {
				result = tmp;
			}

			if (leftHeight > rightHeight) {
				while (left < right && height[right] >= height[right - 1]) {
					right--;
				}
				right--;
			} else {
				while (left < right && height[left] >= height[left + 1]) {
					left++;
				}
				left++;
			}
		}

		return result;
	}
}
