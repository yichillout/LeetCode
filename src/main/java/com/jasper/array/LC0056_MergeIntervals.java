package com.jasper.array;

import java.util.*;

import com.jasper.common.Interval;


public class LC0056_MergeIntervals {

    public int[][] merge(int[][] intervals) {

        List<int[]> result = new ArrayList<>();
        Arrays.sort(intervals, (i1, i2) -> {
            if (i1[0] != i2[0]) {
                return i1[0] - i2[0];
            }
            return i1[1] - i2[1];
        });

        int[] insertInterval = intervals[0];

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] > insertInterval[1]) {
                result.add(new int[]{insertInterval[0], insertInterval[1]});
                insertInterval = intervals[i];
            } else {
                insertInterval[1] = Math.max(insertInterval[1], intervals[i][1]);
            }
        }

        result.add(insertInterval);

        int[][] res = new int[result.size()][2];
        for (int i = 0; i < res.length; i++) {
            res[i] = result.get(i);
        }

        return res;
    }
}
