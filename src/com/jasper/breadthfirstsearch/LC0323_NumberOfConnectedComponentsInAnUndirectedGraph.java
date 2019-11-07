package com.jasper.breadthfirstsearch;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LC0323_NumberOfConnectedComponentsInAnUndirectedGraph {

	// Solution 1 : Union Find
	private int[] roots;

	public int countComponents1(int n, int[][] edges) {

		roots = new int[n];

		for (int i = 0; i < n; i++) {
			roots[i] = i;
		}

		for (int[] e : edges) {
			int r1 = find(e[0]);
			int r2 = find(e[1]);
			if (r1 != r2) {
				roots[r1] = r2;
				n--;
			}
		}
		return n;
	}

	private int find(int x) {
		if (roots[x] == x) {
			return x;
		}
		return roots[x] = find(roots[x]);
	}

	// BFS
	public int countComponents2(int n, int[][] edges) {

		List<List<Integer>> list = new ArrayList<>();
		boolean[] isVisited = new boolean[n];

		for (int i = 0; i < n; i++) {
			list.add(new ArrayList<Integer>());
		}

		for (int i = 0; i < edges.length; i++) {
			list.get(edges[i][0]).add(edges[i][1]);
			list.get(edges[i][1]).add(edges[i][0]);
		}

		int counter = 0;
		for (int i = 0; i < n; i++) {
			if (!isVisited[i]) {
				counter++;

				Queue<Integer> q = new LinkedList<>();
				q.offer(i);
				isVisited[i] = true;

				while (!q.isEmpty()) {
					int tmp = q.poll();
					List<Integer> tmpList = list.get(tmp);
					for (int j = 0; j < tmpList.size(); j++) {
						if (!isVisited[tmpList.get(j)]) {
							q.offer(tmpList.get(j));
							isVisited[tmpList.get(j)] = true;
						}
					}
				}

			}
		}

		return counter;
	}
}
