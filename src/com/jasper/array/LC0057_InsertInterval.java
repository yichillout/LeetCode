package com.jasper.array;

import java.util.ArrayList;
import java.util.List;

import com.jasper.common.Interval;

public class LC0057_InsertInterval {

	public static List<Interval> insert(List<Interval> intervals,
			Interval newInterval) {

		if (intervals == null || newInterval == null)
			return intervals;

		List<Interval> result = new ArrayList<Interval>();

		int index = 0;

		for (Interval interval : intervals) {
			if (interval.end < newInterval.start) {
				result.add(interval);
				index++;
			} else if (interval.start > newInterval.end) {
				result.add(interval);
			} else {
				newInterval.start = Math.min(interval.start, newInterval.start);
				newInterval.end = Math.max(interval.end, newInterval.end);
			}
		}

		result.add(index, newInterval);
		return result;
	}

	public static void main(String[] args) {

		List<Interval> inputArray = new ArrayList<Interval>();
		inputArray.add(new Interval(1, 2));
		inputArray.add(new Interval(3, 5));
		inputArray.add(new Interval(6, 7));
		inputArray.add(new Interval(8, 10));
		inputArray.add(new Interval(12, 16));

		List<Interval> outputArray = insert(inputArray, new Interval(4, 9));
	}
}
