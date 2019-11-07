package com.jasper.heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

import com.jasper.common.Interval;

public class LC0253_MeetingRoomsII {

	public int minMeetingRooms(Interval[] intervals) {
		if (intervals == null || intervals.length == 0)
			return 0;

		Arrays.sort(intervals, (Interval a, Interval b) -> a.start - b.start);

		PriorityQueue<Interval> heap = new PriorityQueue<Interval>(intervals.length,
				(Interval o1, Interval o2) -> o1.end - o2.end);

		heap.offer(intervals[0]);

		for (int i = 1; i < intervals.length; i++) {
			// get the meeting room that finishes earliest
			Interval interval = heap.poll();

			if (intervals[i].start >= interval.end) {
				// if the current meeting starts right after
				// there's no need for a new room, merge the interval
				interval.end = intervals[i].end;
			} else {
				// otherwise, this meeting needs a new room
				heap.offer(intervals[i]);
			}

			// don't forget to put the meeting room back
			heap.offer(interval);
		}

		return heap.size();
	}

}
