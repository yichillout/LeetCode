package com.jasper.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

class Pair {
	int row;
	int col;
	int val;

	public Pair(int row, int col, int val) {
		this.row = row;
		this.col = col;
		this.val = val;
	}
}

class PairComparator implements Comparator<Pair> {
	public int compare(Pair p1, Pair p2) {
		return p1.val - p2.val;
	}
}

public class LC0378_KthSmallestElementInSortedMatrix {

	public int kthSmallest(int[][] matrix, int k) {

		PriorityQueue<Pair> pq = new PriorityQueue<>(k, new PairComparator());

		for (int i = 0; i < matrix.length; i++) {
			if (matrix[i].length != 0) {
				pq.offer(new Pair(i, 0, matrix[i][0]));
			}
		}

		for (int i = 0; i < k - 1; i++) {
			Pair pair = pq.poll();
			if (pair.col + 1 < matrix[0].length) {
				pair.col++;
				pair.val = matrix[pair.row][pair.col];
				pq.offer(pair);
			}
		}

		return pq.peek().val;
	}
}