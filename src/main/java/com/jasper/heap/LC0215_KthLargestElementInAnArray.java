package com.jasper.heap;

import com.annotation.Template;

import java.util.PriorityQueue;

@Template
public class LC0215_KthLargestElementInAnArray {

	// 方法1
	public int findKthLargest1(int[] nums, int k) {
		PriorityQueue<Integer> q = new PriorityQueue<Integer>(k);
		for (int i : nums) {
			q.offer(i);

			if (q.size() > k) {
				q.poll();
			}
		}

		return q.peek();
	}

	// 方法2 利用partition的特性
	public int findKthLargest2(int[] nums, int k) {

		k = nums.length - k;
		int lo = 0;
		int hi = nums.length - 1;
		while (lo < hi) {
			final int j = partition(nums, lo, hi);
			if (j < k) {
				lo = j + 1;
			} else if (j > k) {
				hi = j - 1;
			} else {
				break;
			}
		}
		return nums[k];
	}

	private int partition(int[] nums, int lo, int hi) {

		swap(nums, lo, (int) (Math.random() * (hi - lo + 1)) + lo);

		int v = nums[lo];

		int j = lo; // arr[l+1...j] < v ; arr[j+1...i) > v
		for (int i = lo + 1; i <= hi; i++)
			if (nums[i] < v) {
				j++;
				swap(nums, j, i);
			}

		swap(nums, lo, j);

		return j;
	}

	private void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

}
