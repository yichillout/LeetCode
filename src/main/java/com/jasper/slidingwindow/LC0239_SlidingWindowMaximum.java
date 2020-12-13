package com.jasper.slidingwindow;

import com.annotation.Template;

import java.util.ArrayDeque;
import java.util.Deque;

@Template
public class LC0239_SlidingWindowMaximum {

	// Solution 1
	public int[] maxSlidingWindow1(int[] nums, int k) {
		int[] result = new int[nums.length - k + 1];

		if (nums.length == 0)
			return new int[] {};

		int j = 0;
		for (int i = 0; i < nums.length; i++) {
			if (i - j + 1 < k)
				continue;
			if (i - j + 1 > k) {
				j++;
			}
			result[j] = getMax(nums, j, i);
		}

		return result;
	}

	private int getMax(int[] nums, int start, int end) {
		int max = nums[start];
		for (int i = start; i <= end; i++) {
			if (max < nums[i])
				max = nums[i];
		}
		return max;
	}

	// Solution 2 : dequeue
	public int[] maxSlidingWindow(int[] nums, int k) {

		if (nums.length == 0)
			return new int[] {};

		// store the index
		Deque<Integer> dq = new ArrayDeque<>();

		int[] result = new int[nums.length - k + 1];

		for (int i = 0; i < k - 1; i++) {
			inQueue(nums, dq, i);
		}

		for (int i = k - 1; i < nums.length; i++) {
			inQueue(nums, dq, i);
			result[i - k + 1] = nums[dq.peekFirst()];
			if (dq.peekFirst() == i - k + 1) {
				dq.removeFirst();
			}
		}

		return result;
	}

	private void inQueue(int[] nums, Deque<Integer> dq, int pos) {
		while (!dq.isEmpty() && nums[dq.peekLast()] < nums[pos]) {
			dq.removeLast();
		}
		dq.addLast(pos);
	}
}
