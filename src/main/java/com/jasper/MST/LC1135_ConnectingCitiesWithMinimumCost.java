package com.jasper.MST;

import java.util.PriorityQueue;

class LC1135_ConnectingCitiesWithMinimumCost {

    class UnionFind {

        int[] parents;

        public UnionFind(int n) {
            parents = new int[n + 1];
            for (int i = 1; i <= n; i++) {
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

    public int minimumCost(int n, int[][] connections) {

        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[2] - b[2]);

        for (int[] connection : connections) {
            queue.offer(connection);
        }

        int result = 0;
        int count = 0;

        UnionFind uf = new UnionFind(n);

        while (!queue.isEmpty()) {
            int[] connection = queue.poll();
            if (!uf.isConnected(connection[0], connection[1])) {
                uf.union(connection[0], connection[1]);
                result += connection[2];
                count++;
            }
        }

        if (count == n - 1) {
            return result;
        } else {
            return -1;
        }
    }
}
