package com.jasper.unionfind;


import java.util.ArrayList;
import java.util.List;

public class LC0547_NumberOfProvinces {

    // Solution 1 : union find
    class UnionFind {

        int[] parents;

        public UnionFind(int num) {
            parents = new int[num];
            for (int i = 0; i < num; i++) {
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
            if (parents[num] == num) {
                return num;
            }

            parents[num] = find(parents[num]);
            return parents[num];
        }

        public boolean isConnected(int num1, int num2) {
            return find(num1) == find(num2);
        }

    }

    public int findCircleNum1(int[][] isConnected) {
        int N = isConnected.length;
        UnionFind uf = new UnionFind(N);
        int count = 0;

        for (int i = 0; i < N; i++) {
            for (int j = i; j < N; j++) {
                if (i != j && isConnected[i][j] == 1) {
                    if (!uf.isConnected(i, j)) {
                        uf.union(i, j);
                        count++;
                    }
                }
            }
        }

        return N - count;
    }

    // Solution 2 : dfs
    public int findCircleNum2(int[][] isConnected) {
        int N = isConnected.length;
        boolean[] visited = new boolean[N];
        int count = 0;

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                dfs(i, visited, isConnected);
                count++;
            }
        }

        return count;
    }

    public void dfs(int num, boolean[] visited, int[][] isConnected) {
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i] && isConnected[num][i] == 1) {
                visited[i] = true;
                dfs(i, visited, isConnected);
            }
        }
    }

    // Solution 3 : bfs TODO
}
