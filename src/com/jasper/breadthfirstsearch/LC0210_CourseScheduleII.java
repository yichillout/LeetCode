package com.jasper.breadthfirstsearch;

import java.util.*;

public class LC0210_CourseScheduleII {

	int index = 0;

	public int[] findOrder(int numCourses, int[][] prerequisites) {
		HashMap<Integer, List<Integer>> adj = new HashMap<Integer, List<Integer>>();
		int n = numCourses;
		index = n - 1;
		int[][] pre = prerequisites;
		
		int[] result = new int[n];

		initAdj(n, adj, pre);

		int[] color = new int[n];// 0 white 1 gray 2 black
		for (int i = 0; i < n; i++) {
			if (!canFinishDFS(adj, color, result, i)) {
				return new int[0];
			}
		}// for i
		return result;
	}

	private void initAdj(int n, HashMap<Integer, List<Integer>> adj, int[][] pre) {
		for (int i = 0; i < n; i++) {
			adj.put(i, new LinkedList<Integer>());
		}
		for (int i = 0; i < pre.length; i++) {
			adj.get(pre[i][1]).add(pre[i][0]);
		}
	}

	private boolean canFinishDFS(HashMap<Integer, List<Integer>> adj,
			int[] color, int[] result, int i) {
		if (color[i] == 1)
			return false;
		if (color[i] == 2)
			return true;
		color[i] = 1;
		for (Integer j : adj.get(i)) {
			if (!canFinishDFS(adj, color, result, j)) {
				return false;
			}
		}
		color[i] = 2;
		result[index] = i;
		index--;
		return true;
	}

	public static void main(String[] args) {
		
		

	}
}
