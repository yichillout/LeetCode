package com.jasper.slidingwindow;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class LC0480_SlidingWindowMedian {

    // Solution 1
    public double[] medianSlidingWindow01(int[] nums, int k) {
        double[] result = new double[nums.length - k + 1];
        for (int i = 0; i < nums.length - k + 1; i++) {
            result[i] = getMedian(nums, i, i + k - 1, k);
        }
        return result;
    }

    private double getMedian(int[] nums, int start, int end, int k) {
        int[] newnums = new int[k];

        for (int i = start; i <= end; i++) {
            newnums[i - start] = nums[i];
        }

        Arrays.sort(newnums);


        if (k % 2 == 0) {
            int medianIndex1 = (k - 1) / 2;
            int medianIndex2 = medianIndex1 + 1;
            return (double) ((double) newnums[medianIndex1] + (double) newnums[medianIndex2]) / 2;
        } else {
            int medianIndex = (k - 1) / 2;
            return (double) newnums[medianIndex];
        }
    }

    // Solution 2 : two priority queue
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>((i1, i2) -> i2.compareTo(i1));

    public double[] medianSlidingWindow02(int[] nums, int k) {
        int n = nums.length - k + 1;
        if (n <= 0) return new double[0];
        double[] result = new double[n];

        for (int i = 0; i <= nums.length; i++) {
            if (i >= k) {
                result[i - k] = getMedian();
                remove(nums[i - k]);
            }
            if (i < nums.length) {
                add(nums[i]);
            }
        }

        return result;
    }

    private void add(int num) {
        if (num < getMedian()) {
            maxHeap.add(num);
        } else {
            minHeap.add(num);
        }
        if (maxHeap.size() > minHeap.size()) {
            minHeap.add(maxHeap.poll());
        }
        if (minHeap.size() - maxHeap.size() > 1) {
            maxHeap.add(minHeap.poll());
        }
    }

    private void remove(int num) {
        if (num < getMedian()) {
            maxHeap.remove(num);
        } else {
            minHeap.remove(num);
        }
        if (maxHeap.size() > minHeap.size()) {
            minHeap.add(maxHeap.poll());
        }
        if (minHeap.size() - maxHeap.size() > 1) {
            maxHeap.add(minHeap.poll());
        }
    }

    private double getMedian() {
        if (maxHeap.isEmpty() && minHeap.isEmpty()) return 0;

        if (maxHeap.size() == minHeap.size()) {
            return ((double) maxHeap.peek() + (double) minHeap.peek()) / 2.0;
        } else {
            return (double) minHeap.peek();
        }
    }
}
