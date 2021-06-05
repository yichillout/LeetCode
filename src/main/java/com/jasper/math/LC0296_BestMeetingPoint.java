package com.jasper.math;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LC0296_BestMeetingPoint {

	public static int minTotalDistance(int[][] grid) {
		List<Integer> rows = new ArrayList<>(), cols = new ArrayList<>();
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 1) {
					rows.add(i);
					cols.add(j);
				}
			}
		}
		Collections.sort(cols);
		return getMinDist(rows) + getMinDist(cols);
	}

	private static int getMinDist(List<Integer> list) {
		
		if (list == null || list.size() == 0)
			return Integer.MAX_VALUE;
		
		int median = list.get(list.size() / 2);
		
		int minDist = 0;
		
		for (int idx : list) {
			if (idx < median)
				minDist += median - idx;
			else
				minDist += idx - median;
		}
		
		return minDist;
	}

	public static void main(String[] args) {

		int[][] grid = { 
				{ 1, 0, 0, 0, 1 }, 
				{ 0, 0, 0, 0, 0 },
				{ 0, 0, 1, 0, 0 }};
		
		System.out.println(minTotalDistance(grid));

	}

}
