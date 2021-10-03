package com.jasper.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.jasper.common.Interval;

public class LC0057_InsertInterval {

    // solution 1
    public int[][] insert1(int[][] intervals, int[] newInterval) {

        Arrays.sort(intervals, (int[] i1, int[] i2) -> {
            if (i1[0] == i2[0]) {
                return i1[1] = i2[1];
            }

            return i1[0] - i2[0];
        });

        List<int[]> result = new ArrayList<>();
        int[] tmp = newInterval;

        for (int i = 0; i < intervals.length; i++) {
            if (intervals[i][0] > tmp[1]) {
                // tmp        [x   y]
                // interval           [a    b]
                result.add(tmp);
                tmp = intervals[i];
            } else if (intervals[i][1] >= tmp[0]) {
                // tmp             [x   y]
                // interval   [a    b]
                int start = Math.min(intervals[i][0], tmp[0]);
                int end = Math.max(intervals[i][1], tmp[1]);
                tmp = new int[]{start, end};
            } else {
                // tmp                  [x   y]
                // interval   [a    b]
                result.add(intervals[i]);
            }
        }

        result.add(tmp);

        return result.toArray(new int[result.size()][2]);
    }

    // solution 2
    public int[][] insert2(int[][] intervals, int[] newInterval) {

        if (intervals == null || newInterval == null) {
            return new int[0][2];
        }

        List<int[]> result = new ArrayList<>();

        int index = 0;

        for (int[] interval : intervals) {
            if (interval[0] > newInterval[1]) {
                result.add(interval);
            } else if (interval[1] >= newInterval[0]) {
                int start = Math.min(interval[0], newInterval[0]);
                int end = Math.max(interval[1], newInterval[1]);
                newInterval = new int[]{start, end};
            } else {
                result.add(interval);
                index++;
            }
        }

        result.add(index, newInterval);

        return result.toArray(new int[result.size()][2]);
    }
}
