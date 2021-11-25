package com.jasper.heap;

import java.util.*;

class MedianFinder {
    private PriorityQueue<Integer> maxQ;
    private PriorityQueue<Integer> minQ;

    public MedianFinder() {
        this.minQ = new PriorityQueue<Integer>();
        this.maxQ = new PriorityQueue<Integer>(new Comparator<Integer>() {
            public int compare(Integer i1, Integer i2) {
                return i2 - i1;
            }
        });
    }

    // 之所以要进入max和min各一次是因为要确定num的最终去处, 需要两边比较才能知道
    public void addNum(int num) {
        maxQ.add(num); // O(logn)
        minQ.add(maxQ.poll()); // O(logn)
        if (maxQ.size() < minQ.size()) {
            maxQ.add(minQ.poll()); // O(logn)
        }
    }

    public double findMedian() { // O(1)
        if (maxQ.size() == minQ.size())
            return (maxQ.peek() + minQ.peek()) / 2.0;
        else
            return maxQ.peek();
    }
}

public class LC0295_FindMedianfromDataStream {

    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(3);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(10);
        medianFinder.addNum(8);
        medianFinder.addNum(7);
    }

}
