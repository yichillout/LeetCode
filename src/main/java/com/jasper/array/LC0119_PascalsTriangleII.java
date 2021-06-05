package com.jasper.array;

import java.util.ArrayList;
import java.util.List;

public class LC0119_PascalsTriangleII {

	public List<Integer> getRow(int rowIndex) {

		List<Integer> result = new ArrayList<Integer>();
		List<Integer> prev = null;

		if (rowIndex < 0)
			return result;

		result.add(1);
		prev = result;

		for (int i = 1; i <= rowIndex; i++) {
			result = new ArrayList<Integer>();
			result.add(1);
			for (int j = 1; j < i; j++) {
				result.add(prev.get(j - 1) + prev.get(j));
			}
			result.add(1);
			prev = result;
		}
		return result;
	}
}
