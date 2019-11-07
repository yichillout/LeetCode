package com.jasper.queue;

public class LC0346_MovingAveragefromDataStream {

	private int[] window;
	private int n, insert;
	private long sum;

	/** Initialize your data structure here. */
	public LC0346_MovingAveragefromDataStream(int size) {
		window = new int[size];
		insert = 0;
		sum = 0;
	}

	public double next(int val) {
		if (n < window.length)
			n++;
		sum -= window[insert];
		sum += val;
		window[insert] = val;
		insert = (insert + 1) % window.length;

		return (double) sum / n;
	}

	public static void main(String[] args) {
		LC0346_MovingAveragefromDataStream test = new LC0346_MovingAveragefromDataStream(3);
		System.out.println(test.next(1));
		System.out.println(test.next(10));
		System.out.println(test.next(3));
		System.out.println(test.next(5));;
	}
}
