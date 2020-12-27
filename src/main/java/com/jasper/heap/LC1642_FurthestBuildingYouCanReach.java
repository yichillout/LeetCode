package com.jasper.heap;

import java.util.PriorityQueue;

public class LC1642_FurthestBuildingYouCanReach {

    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < heights.length - 1; i++) {
            int d = heights[i + 1] - heights[i];

            if (d > 0) {
                pq.add(d);
            }

            if (pq.size() > ladders) {
                bricks -= pq.poll();
            }

            if (bricks < 0) {
                return i;
            }
        }

        return heights.length - 1;
    }
}
