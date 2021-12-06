package com.jasper.design;

import java.util.*;

class MovingAverage {
    Queue<Integer> queue;
    int capacity;
    double sum;

    public MovingAverage(int size) {
        queue = new LinkedList<>();
        capacity = size;
        sum = 0.0;
    }

    public double next(int val) {
        if (queue.size() >= capacity) {
            sum -= queue.poll();
        }

        queue.offer(val);
        sum += val;
        return sum / queue.size();
    }
}

public class LC0346_MovingAveragefromDataStream {

}
