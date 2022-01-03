package com.company.microsoft;

import java.util.PriorityQueue;

public class FactoriesQuestion {

    public static void main(String[] args) {
        int[] arr = {5, 19, 8, 1};
        //int[] arr = {10, 10};
        System.out.println(minFilters(arr));
    }

    public static int minFilters(int[] arr) {
        PriorityQueue<Double> pq = new PriorityQueue<>((a, b) -> Double.compare(b, a));
        double total = 0.0;
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            total += arr[i];
            pq.offer((double) arr[i]);
        }

        double target = total / 2;

        while (!pq.isEmpty() && total > target) {
            double popped = pq.poll();
            total -= popped / 2;
            count++;
            pq.offer(popped / 2);
        }

        return count;
    }
}
