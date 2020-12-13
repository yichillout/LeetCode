package com.jasper.binarysearch;

public class LC0410_SplitArrayLargestSum {

	public int splitArray(int[] nums, int m) {

		long start = 0;
		long end = 0;

		for (int num : nums) {
			start = Math.max(start, num);
			end += num;
		}

		while (start + 1 < end) {
			long mid = start + (end - start) / 2;
			if (getNeed(mid, nums) <= m) {
				end = mid;
			} else {
				start = mid;
			}
		}

		if (getNeed(start, nums) <= m) {
			return (int) start;
		}

		return (int) end;
	}

	private int getNeed(long max, int[] nums) {
		int need = 1;
		long cur = 0;
		for (int num : nums) {
			if (cur + num > max) {
				need++;
				cur = 0;
			}
			cur += num;
		}
		return need;
	}
}
