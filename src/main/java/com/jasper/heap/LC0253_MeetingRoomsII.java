package com.jasper.heap;

import java.util.*;

import com.jasper.common.Interval;

public class LC0253_MeetingRoomsII {

    // solution 1 : heap
    public int minMeetingRooms1(int[][] intervals) {

        PriorityQueue<int[]> pq = new PriorityQueue<>((int[] a, int[] b) -> a[1] - b[1]);

        Arrays.sort(intervals, (int[] a, int[] b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });

        for (int[] interval : intervals) {
            if (pq.isEmpty()) {
                pq.offer(interval);
                continue;
            }

            if (pq.peek()[1] > interval[0]) {
                pq.offer(interval);
            } else if (pq.peek()[1] <= interval[0] && pq.peek()[1] < interval[1]) {
                int[] tmp = pq.poll();
                tmp[1] = interval[1];
                pq.offer(tmp);
            }

        }

        return pq.size();
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

    public int minMeetingRooms2(int[][] intervals) {

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
