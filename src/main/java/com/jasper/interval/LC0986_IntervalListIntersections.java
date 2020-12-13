package com.jasper.interval;

import java.util.ArrayList;
import java.util.List;

import com.jasper.common.Interval;

public class LC0986_IntervalListIntersections {

	public Interval[] intervalIntersection(Interval[] A, Interval[] B) {
		if (A == null || A.length == 0 || B == null || B.length == 0) {
			return new Interval[] {};
		}

		int m = A.length;
		int n = B.length;
		int i = 0, j = 0;

		List<Interval> res = new ArrayList<>();

		while (i < m && j < n) {

			Interval a = A[i];
			Interval b = B[j];

			int startMax = Math.max(a.start, b.start);
			int endMin = Math.min(a.end, b.end);

			if (endMin >= startMax) {
				res.add(new Interval(startMax, endMin));
			}

			// update the pointer with smaller end value...
			if (a.end == endMin) {
				i++;
			}

			if (b.end == endMin) {
				j++;
			}
		}

		return res.toArray(new Interval[0]);
	}

}
