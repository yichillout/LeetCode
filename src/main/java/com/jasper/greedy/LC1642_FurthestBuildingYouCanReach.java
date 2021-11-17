package com.jasper.greedy;

import java.util.PriorityQueue;

public class LC1642_FurthestBuildingYouCanReach {

    public int furthestBuilding(int[] heights, int bricks, int ladders) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 1; i < heights.length; i++) {
            int curDiff = heights[i] - heights[i - 1];
            if (curDiff <= 0) {
                continue;
            }

            pq.add(curDiff);

            if (pq.size() > ladders) {
                bricks -= pq.poll();
            }

            if (bricks < 0) {
                return i - 1;
            }
        }

        return heights.length - 1;
    }
}