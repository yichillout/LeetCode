package com.jasper.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.jasper.common.Interval;

class IntervalComparator implements Comparator<Interval> {
	@Override
	public int compare(Interval a, Interval b) {
		return a.start - b.start;
	}
}

public class LC0056_MergeIntervals {

	public static List<Interval> merge(List<Interval> intervals) {

		List<Interval> result = new ArrayList<Interval>();
		IntervalComparator intervalComparator = new IntervalComparator();

		Collections.sort(intervals, intervalComparator); // important!!!!

		if (intervals == null || intervals.size() == 0)
			return result;

		Interval temp = intervals.get(0);

		for (int i = 1; i < intervals.size(); i++) {
			Interval cur = intervals.get(i);
			if (cur.start > temp.end) {
				result.add(temp);
				temp = cur;
			} else {
				temp.end = Math.max(temp.end, cur.end);
			}

		}

		result.add(temp);

		return result;
	}

	public static void main(String[] args) {

		List<Interval> inputArray = new ArrayList<Interval>();
		inputArray.add(new Interval(1, 3));
		inputArray.add(new Interval(2, 6));
		inputArray.add(new Interval(15, 18));
		inputArray.add(new Interval(8, 10));

		List<Interval> outputArray = merge(inputArray);
	}
}
