package com.jasper.unionfind;

import java.util.HashMap;
import java.util.Map;

public class LC0547_FriendCircles {

	class UnionFind {

		Map<Integer, Integer> parents = new HashMap<>();

		public UnionFind(int n) {
			for (int i = 0; i < n; i++) {
				parents.put(i, i);
			}
		}

		public void union(int id1, int id2) {
			int p1 = find(id1);
			int p2 = find(id2);
			if (p1 == p2) {
				return;
			}
			parents.put(p1, p2);
		}

		public int find(int id) {
			if (parents.get(id) != id) {
				parents.put(id, find(parents.get(id)));
			}
			return parents.get(id);
		}
	}

	public int findCircleNum(int[][] M) {

		int n = M.length;

		UnionFind uf = new UnionFind(n);

		int count = n;

		for (int i = 0; i < n; i++) {
			for (int j = i; j < n; j++) {
				if (M[i][j] == 1) {
					int p1 = uf.find(i);
					int p2 = uf.find(j);
					if (p1 != p2) {
						uf.union(i, j);
						count--;
					}
				}
			}
		}

		return count;
	}
}
