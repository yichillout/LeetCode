package com.jasper.unionfind;

public class LC0684_RedundantConnection {

    static class UnionFind {
        int[] parents;

        public UnionFind(int n) {
            parents = new int[n + 1];
            for (int i = 0; i < parents.length; i++) {
                parents[i] = i;
            }
        }

        public void union(int id1, int id2) {
            int p1 = find(id1);
            int p2 = find(id2);
            if (p1 == p2)
                return;
            parents[p1] = p2; // should be parents[p1] but not parents[id1];
        }

        public int find(int id) {
            if (parents[id] != id) {
                parents[id] = find(parents[id]);
            }
            return parents[id];
        }
    }

    public static int[] findRedundantConnection(int[][] edges) {

        UnionFind uf = new UnionFind(edges.length);

        for (int[] edge : edges) {
            int p1 = uf.find(edge[0]);
            int p2 = uf.find(edge[1]);
            if (p1 == p2) {
                return edge;
            }
            uf.union(edge[0], edge[1]);
        }

        return null;
    }

    public static void main(String[] args) {
        int[][] edges = new int[][]{{1, 2}, {2, 3}, {3, 4}, {1, 4}, {1, 5}};
        findRedundantConnection(edges);
    }
}
