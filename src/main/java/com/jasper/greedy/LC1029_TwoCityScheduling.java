package com.jasper.greedy;

import java.util.Arrays;
import java.util.PriorityQueue;

public class LC1029_TwoCityScheduling {

	/*
	 * 假设所有的人都选择城市A， 这时候sum=sum{a[i][0]}, 然后要选择一半的人改成B， 这个时候,
	 * 选择某一个人对sum的影响是d=a[i][1]-a[i][0], 那么， 我们要让结果最小， 就需要让这个d最小，
	 * 那按照这个d对数组排序，然后选择最小的一半就好
	 */

	public int twoCitySchedCost(int[][] costs) {
		Arrays.sort(costs, (a, b) -> {
			int diff1 = a[1] - a[0];
			int diff2 = b[1] - b[0];
			return diff1 - diff2;
		});

		int sum = 0;
		for (int i = 0; i < costs.length; i++) {
			sum += costs[i][0];
		}

		for (int i = 0; i < costs.length / 2; i++) {
			sum += costs[i][1] - costs[i][0];
		}

		return sum;
	}
}
