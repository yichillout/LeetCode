package com.jasper.heap;

import java.util.*;

import com.jasper.common.Interval;

public class LC0253_MeetingRoomsII {

    // solution 1 : heap
    public int minMeetingRooms(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }

        Arrays.sort(intervals, (Interval a, Interval b) -> a.start - b.start);

        PriorityQueue<Interval> heap = new PriorityQueue<>(intervals.length, (Interval o1, Interval o2) -> o1.end - o2.end);

        heap.offer(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            Interval interval = heap.poll();

            if (intervals[i].start >= interval.end) {
                interval.end = intervals[i].end;
            } else {
                heap.offer(intervals[i]);
            }

            heap.offer(interval);
        }

        return heap.size();
    }

    // solution 2 : sweep line
    class Point {

        int time;
        int flag;

        Point(int time, int flag) {
            this.time = time;
            this.flag = flag;
        }

    }

    class SortByFlag implements Comparator<Point> {
        public int compare(Point a, Point b) {
            if (a.time == b.time) {
                return b.flag - a.flag;
            }

            return a.time - b.time;
        }
    }

    public int minMeetingRooms(int[][] intervals) {

        int res = 0;
        int cur = 0;

        List<Point> points = new ArrayList<>();

        for (int i = 0; i < intervals.length; i++) {
            int[] interval = intervals[i];
            points.add(new Point(interval[0], 0));
            points.add(new Point(interval[1], 1));
        }

        Collections.sort(points, new SortByFlag());

        for (Point point : points) {
            if (point.flag == 0) {
                cur++;
                res = Math.max(cur, res);
            } else {
                cur--;
            }
        }

        return res;
    }

}
