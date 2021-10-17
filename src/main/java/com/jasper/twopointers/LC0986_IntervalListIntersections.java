package com.jasper.twopointers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LC0986_IntervalListIntersections {

    // solution 1 : two pointers
    public int[][] intervalIntersection1(int[][] firstList, int[][] secondList) {

        int index1 = 0;
        int index2 = 0;

        List<int[]> result = new ArrayList<>();

        while (index1 < firstList.length && index2 < secondList.length) {
            int[] first = firstList[index1];
            int[] second = secondList[index2];

            if (isValid(first[0], first[1], second[0], second[1])) {
                result.add(new int[]{Math.max(first[0], second[0]), Math.min(first[1], second[1])});
            }

            if (first[1] >= second[1]) {
                index2++;
            } else {
                index1++;
            }
        }

        int[][] r = new int[result.size()][2];
        for (int i = 0; i < r.length; i++) {
            r[i] = result.get(i);
        }

        return r;
    }

    /**
     *
     * @param s1
     * @param e1
     * @param s2
     * @param e2
     * @return
     *
     * scenario 1 : s1 <= e2 && e1 >= s2
     *   [s1     e1]
     *      [s2       e2]
     * scenario 2 : s2 <= e1 && e2 >= s1  ====  s1 <= e2 && e1 >= s2
     *         [s1     e1]
     *   [s2       e2]
     */
    public boolean isValid(int s1, int e1, int s2, int e2) {
        return (s1 <= e2 && e1 >= s2) || (s2 <= e1 && e2 >= s1);
    }

    // solution 2 : sweep line
    class Point {
        int val;
        int flag;

        public Point(int val, int flag) {
            this.val = val;
            this.flag = flag;
        }
    }

    public int[][] intervalIntersection2(int[][] firstList, int[][] secondList) {
        List<Point> points = new ArrayList<>();
        List<int[]> result = new ArrayList<>();
        int count = 0;

        for (int[] first : firstList) {
            points.add(new Point(first[0], 0));
            points.add(new Point(first[1], 1));
        }

        for (int[] second : secondList) {
            points.add(new Point(second[0], 0));
            points.add(new Point(second[1], 1));
        }

        Collections.sort(points, (Point p1, Point p2) -> {
            if (p1.val == p2.val) {
                return p1.flag - p2.flag;
            }

            return p1.val - p2.val;
        });

        int start = Integer.MIN_VALUE;
        int end = Integer.MIN_VALUE;


        for (Point point : points) {
            if (point.flag == 0) {
                count++;
                if (count == 2) {
                    start = point.val;
                }
            } else {
                count--;
                if (count == 1) {
                    end = point.val;
                }
            }

            if (start != Integer.MIN_VALUE && end != Integer.MIN_VALUE) {
                result.add(new int[]{start, end});
                start = Integer.MIN_VALUE;
                end = Integer.MIN_VALUE;
            }
        }

        int[][] r = new int[result.size()][2];
        for (int i = 0; i < result.size(); i++) {
            r[i] = result.get(i);
        }

        return r;
    }
}
