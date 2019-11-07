package com.jasper.binarysearch;

public class LC1014_CapacityToShipPackagesWithinKDays {

	public int shipWithinDays(int[] weights, int D) {
		int start = 0;
		int end = 0;

		for (int w : weights) {
			start = Math.max(start, w);
			end += w;
		}
		while (start + 1 < end) {
			int mid = (start + end) / 2;
			int need = getNeed(mid, weights);
			if (need <= D) {
				end = mid;
			} else {
				start = mid;
			}
		}

		if (getNeed(start, weights) <= D) {
			return start;
		}
		return end;
	}

	private int getNeed(int maxWeight, int[] weights) {
		int need = 1;
		int cur = 0;
		for (int w : weights) {
			if (cur + w > maxWeight) {
				need += 1;
				cur = 0;
			}
			cur += w;
		}
		return need;
	}
}
