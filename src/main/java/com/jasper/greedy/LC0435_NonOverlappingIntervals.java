package com.jasper.greedy;

import java.util.Arrays;
import java.util.Comparator;

import com.jasper.common.Interval;

public class LC0435_NonOverlappingIntervals {

	public int eraseOverlapIntervals(Interval[] intervals) {

		if (intervals == null || intervals.length == 0)
			return 0;

		Arrays.sort(intervals, new myComparator());
		int counter = 1;
		int end = intervals[0].end;

		for (int i = 1; i < intervals.length; i++) {
			if (intervals[i].start >= end) {
				end = intervals[i].end;
				counter++;
			}
		}

		return intervals.length - counter;
	}

	class myComparator implements Comparator<Interval> {
		public int compare(Interval a, Interval b) {
			return a.end - b.end;
		}
	}

}
