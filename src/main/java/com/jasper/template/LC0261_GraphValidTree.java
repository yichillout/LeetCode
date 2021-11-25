package com.jasper.template;

import com.annotation.Template;

@Template
public class LC0261_GraphValidTree {

	// Union Find
	class UnionFind {

		int[] data;

		public UnionFind(int n) {
			data = new int[n];
			for(int i = 0; i < n; i++) {
				data[i] = i;
			}
		}


		public boolean isConnected(int x, int y) {
			int xp = find(x);
			int yp = find(y);
			return xp == yp;
		}

		public void union(int x, int y) {
			if(!isConnected(x, y)) {
				int xp = find(x);
				int yp = find(y);
				data[xp] = yp;
			}
		}

		public int find(int x) {
			int p = data[x];

			if(p != x) {
				data[x] = find(p);
			}

			return data[x] ;
		}

	}

	public boolean validTree(int n, int[][] edges) {

		UnionFind uf = new UnionFind(n);

		for(int[] edge : edges) {
			if(!uf.isConnected(edge[0], edge[1])) {
				uf.union(edge[0], edge[1]);
			} else {
				return false;
			}
		}

		return n == edges.length + 1;
	}
}
