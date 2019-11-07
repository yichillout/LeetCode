package com.jasper.array;

import java.util.ArrayList;
import java.util.List;

public class LC0118_PascalsTriangle {

	// Solution 1
	public List<List<Integer>> generate1(int numRows) {

		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> prev = null;

		if (numRows < 1)
			return result;

		List<Integer> firstRow = new ArrayList<Integer>();
		firstRow.add(1);
		result.add(firstRow);

		for (int i = 1; i < numRows; i++) {
			List<Integer> newRow = new ArrayList<Integer>();
			newRow.add(1);

			for (int j = 1; j < i; j++) {
				newRow.add(prev.get(j - 1) + prev.get(j));
			}

			newRow.add(1);
			result.add(newRow);
			prev = newRow;
		}

		return result;
	}

	// Solution 2
	public List<List<Integer>> generate2(int numRows) {

		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> prev = null;

		for (int i = 0; i < numRows; i++) {
			List<Integer> newRow = new ArrayList<Integer>();
			for (int j = 0; j <= i; j++) {
				if (j == 0 || j == i) {
					newRow.add(1);
				} else {
					newRow.add(prev.get(j - 1) + prev.get(j));
				}
			}
			prev = newRow;
			result.add(newRow);
		}

		return result;
	}

}
