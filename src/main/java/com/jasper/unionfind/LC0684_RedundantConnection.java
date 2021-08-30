package com.jasper.unionfind;

public class LC0684_RedundantConnection {

    class UnionFind {

        int[] parent;

        public UnionFind(int n) {
            parent = new int[n + 1];
            for (int i = 0; i < parent.length; i++) {
                parent[i] = i;
            }
        }

        public int find(int num) {
            if (parent[num] != num) {
                parent[num] = find(parent[num]);
            }

            return parent[num];
        }

        public boolean union(int num1, int num2) {

            int p1 = find(num1);
            int p2 = find(num2);

            if (p1 != p2) {
                parent[p1] = p2;
                return true;
            }

            return false;
        }

    }

    public int[] findRedundantConnection(int[][] edges) {

        UnionFind uf = new UnionFind(edges.length);

        for (int i = 0; i < edges.length; i++) {
            if (!uf.union(edges[i][0], edges[i][1])) {
                return edges[i];
            }
        }

        return null;
    }
}