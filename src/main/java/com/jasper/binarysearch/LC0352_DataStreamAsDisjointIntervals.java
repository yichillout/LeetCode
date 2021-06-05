package com.jasper.binarysearch;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

import com.jasper.common.Interval;

/**
 * Definition for an interval.
 * public class Interval {
 * int start;
 * int end;
 * Interval() { start = 0; end = 0; }
 * Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class LC0352_DataStreamAsDisjointIntervals {
    /**
     * Initialize your data structure here.
     */

    private TreeSet<Interval> intervalSet;

    public LC0352_DataStreamAsDisjointIntervals() {
        intervalSet = new TreeSet<Interval>(new Comparator<Interval>() {
            public int compare(Interval a, Interval b) {
                return a.start - b.start;
            }
        });
    }

    public void addNum(int val) {
        Interval valInterval = new Interval(val, val);
        Interval floor = intervalSet.floor(valInterval);
        if (floor != null) {
            if (floor.end >= val) {
                return;
            } else if (floor.end + 1 == val) {
                valInterval.start = floor.start;
                intervalSet.remove(floor);
            }
        }
        Interval higher = intervalSet.higher(valInterval);
        if (higher != null && higher.start == val + 1) {
            valInterval.end = higher.end;
            intervalSet.remove(higher);
        }
        intervalSet.add(valInterval);
    }

    public List<Interval> getIntervals() {
        return Arrays.asList(intervalSet.toArray(new Interval[0]));
    }
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(val);
 * List<Interval> param_2 = obj.getIntervals();
 */
