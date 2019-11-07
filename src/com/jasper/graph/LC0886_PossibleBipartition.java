package com.jasper.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class LC0886_PossibleBipartition {

	// Solution 1 : DFS
	// group[i] = 0 means node i hasn't been visited.
	// group[i] = 1 means node i has been grouped to 1.
	// group[i] = -1 means node i has been grouped to -1.
	public boolean possibleBipartition1(int N, int[][] dislikes) {

		Map<Integer, Set<Integer>> graph = new HashMap<>();

		for (int i = 1; i <= N; i++) {
			graph.put(i, new HashSet<Integer>());
		}

		for (int[] d : dislikes) {
			graph.get(d[0]).add(d[1]);
			graph.get(d[1]).add(d[0]);
		}

		// to store the number belong to which group
		int[] group = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			if (group[i] == 0 && !dfs(graph, group, i, 1)) {
				return false;
			}
		}

		return true;
	}

	private boolean dfs(Map<Integer, Set<Integer>> graph, int[] group, int i, int g) {

		group[i] = g;

		for (int num : graph.get(i)) {
			// the same group -> return false
			if (group[num] == g) {
				return false;
			}
			// not visited -> dfs
			if (group[num] == 0 && !dfs(graph, group, num, -g)) {
				return false;
			}
		}
		return true;
	}

	// Solution 2 : BFS
	public boolean possibleBipartition2(int N, int[][] dislikes) {

		int[] group = new int[N + 1];
		int color = 1;

		Map<Integer, Set<Integer>> graph = new HashMap<>();

		for (int i = 1; i <= N; i++) {
			graph.put(i, new HashSet<Integer>());
		}

		for (int[] d : dislikes) {
			graph.get(d[0]).add(d[1]);
			graph.get(d[1]).add(d[0]);
		}

		for (int i = 1; i <= N; i++) {
			if (group[i] == 0) {
				Queue<Integer> q = new LinkedList<>();
				q.offer(i);
				group[i] = color;
				while (!q.isEmpty()) {
					int cur = q.poll();
					Set<Integer> nexts = graph.get(cur);
					for (Integer next : nexts) {
						if (group[next] == 0) {
							group[next] = -group[cur];
							q.offer(next);
						} else {
							if (group[next] == group[cur]) {
								return false;
							}
						}
					}
				}
			}
		}

		return true;
	}
}
