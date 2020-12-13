package com.jasper.graph;

import java.util.LinkedList;
import java.util.Queue;

public class LC0785_IsGraphBipartite {

	public boolean isBipartite(int[][] graph) {
		int len = graph.length;
		int[] colors = new int[len];

		for (int i = 0; i < len; i++) {

			if (colors[i] != 0)
				continue;

			Queue<Integer> queue = new LinkedList<>();
			queue.offer(i);
			colors[i] = 1; // Blue: 1; Red: -1.

			while (!queue.isEmpty()) {
				int cur = queue.poll();
				for (int next : graph[cur]) {
					if (colors[next] == 0) { // If this node hasn't been colored;
						colors[next] = -colors[cur]; // Color it with a different color;
						queue.offer(next);
					} else if (colors[next] != -colors[cur]) {
						return false;
					}
				}
			}
		}

		return true;
	}

}
