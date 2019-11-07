package com.jasper.design;

import java.util.*;

class MovingAverage {

	int size;
	double sum;
	Queue<Double> queue;

	/** Initialize your data structure here. */
	public MovingAverage(int size) {
		this.queue = new LinkedList<Double>();
		this.size = size;
		this.sum = 0.0;
	}

	public double next(int val) {

		if (queue.size() >= size) {
			sum -= queue.peek();
			queue.poll();
			queue.offer(val + 0.0d);
			sum += val;
			return sum / queue.size();
		}

		queue.add(val + 0.0d);
		sum += val;
		return sum / queue.size();
	}
}

public class LC0346_MovingAveragefromDataStream {

}
