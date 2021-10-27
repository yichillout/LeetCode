package com.jasper.geometry;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LC0939_MinimumAreaRectangle {

    public int minAreaRect(int[][] points) {

        Map<Integer, Set<Integer>> hm = new HashMap<>();

        for (int[] point : points) {
            if (!hm.containsKey(point[0])) {
                hm.put(point[0], new HashSet<>());
            }

            hm.get(point[0]).add(point[1]);
        }


        int min = Integer.MAX_VALUE;

        for (int i = 0; i < points.length - 1; i++) {
            for (int j = i + 1; j < points.length; j++) {

                int[] point1 = points[i];
                int[] point2 = points[j];

                if (point1[0] == point2[0] || point1[1] == point2[1]) {
                    continue;
                }

                if (hm.get(point1[0]).contains(point2[1]) && hm.get(point2[0]).contains(point1[1])) {
                    int area = Math.abs(point1[0] - point2[0]) * Math.abs(point1[1] - point2[1]);
                    min = area < min ? area : min;
                }
            }
        }

        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
