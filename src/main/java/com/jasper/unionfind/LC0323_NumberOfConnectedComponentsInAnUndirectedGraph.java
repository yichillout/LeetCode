package com.jasper.unionfind;

public class LC0323_NumberOfConnectedComponentsInAnUndirectedGraph {

    class UnionFind {

        int[] parents;

        public UnionFind(int n) {
            parents = new int[n];
            for (int i = 0; i < n; i++) {
                parents[i] = i;
            }
        }

        public void union(int num1, int num2) {
            int p1 = find(num1);
            int p2 = find(num2);
            if (p1 != p2) {
                parents[p1] = p2;
            }
        }

        public int find(int num) {
            if (num == parents[num]) {
                return num;
            }

            parents[num] = find(parents[num]);
            return parents[num];
        }

        public boolean isConnected(int num1, int num2) {
            return find(num1) == find(num2);
        }

    }

    public int countComponents(int n, int[][] edges) {

        UnionFind uf = new UnionFind(n);
        int count = 0;
        for (int[] edge : edges) {
            if (!uf.isConnected(edge[0], edge[1])) {
                count++;
                uf.union(edge[0], edge[1]);
            }
        }

        return n - count;
    }
}
