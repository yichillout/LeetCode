package com.jasper.template;

public class LC0261_GraphValidTree {

	// Union Find
	public boolean validTree(int n, int[][] edges) {

		int[] roots = new int[n];
		for (int i = 0; i < n; i++) {
			roots[i] = i;
		}

		for (int i = 0; i < edges.length; i++) {
			int r1 = find(roots, edges[i][0]);
			int r2 = find(roots, edges[i][1]);
			if (r1 == r2) {
				return false;
			}
			roots[r1] = r2;
		}

		return edges.length == n - 1;
	}

	private int find(int[] roots, int x) {
		if (roots[x] == x) {
			return x;
		}
		return roots[x] = find(roots, roots[x]);
	}
}
