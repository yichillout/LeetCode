package com.jasper.slidingwindow;

import java.util.Arrays;

public class LC0480_SlidingWindowMedian {

	// Solution 1 : Time Limit Exceeded
	public double[] medianSlidingWindow(int[] nums, int k) {
		double[] result = new double[nums.length - k + 1];
		for (int i = 0; i < nums.length - k + 1; i++) {
			result[i] = getMedian(nums, i, i + k - 1, k);
		}
		return result;
	}

	private double getMedian(int[] nums, int start, int end, int k) {
		int[] newnums = new int[k];

		for (int i = start; i <= end; i++) {
			newnums[i - start] = nums[i];
		}

		Arrays.sort(newnums);
		// for(int num : newnums) {
		// System.out.print(num + " ");
		// }
		// System.out.print("\n");

		if (k % 2 == 0) {
			int medianIndex1 = (k - 1) / 2;
			int medianIndex2 = medianIndex1 + 1;
			return (double) ((double) newnums[medianIndex1] + (double) newnums[medianIndex2]) / 2;
		} else {
			int medianIndex = (k - 1) / 2;
			return (double) newnums[medianIndex];
		}
	}

	// Solution 2 : two priority queue

}
