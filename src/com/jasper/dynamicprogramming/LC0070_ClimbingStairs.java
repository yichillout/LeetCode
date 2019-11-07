package com.jasper.dynamicprogramming;

public class LC0070_ClimbingStairs {

	public int climbStairs(int n) {

		if (n > 0 && n <= 2) {
			return n;
		}

		int[] way = new int[n];
		way[0] = 1;
		way[1] = 2;
		for (int i = 2; i < n; i++) {
			way[i] = way[i - 1] + way[i - 2];
		}

		return way[n - 1];
	}

}
