package com.jasper.heap;

import java.util.PriorityQueue;

public class LC1167_MinimumCostToConnectSticks {

    public int connectSticks(int[] sticks) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int stick : sticks) {
            pq.offer(stick);
        }

        int sum = 0;
        while (pq.size() > 1) {
            int num1 = pq.poll();
            int num2 = pq.poll();
            sum += num1 + num2;
            pq.offer(num1 + num2);
        }

        return sum;
    }
}
