package com.jasper.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class LC0630_CourseScheduleIII {

    public int scheduleCourse(int[][] courses) {

        PriorityQueue<Integer> pq = new PriorityQueue<>((d1, d2) -> d2 - d1);
        Arrays.sort(courses, (c1, c2) -> c1[1] - c2[1]);

        int time = 0;

        for (int[] course : courses) {
            time += course[0];
            pq.offer(course[0]);
            if (time > course[1]) {
                //If time exceeds, drop the previous course which costs the most time. (That must be the best choice!)
                int cTime = pq.poll();
                time -= cTime;
            }
        }

        return pq.size();
    }
}
