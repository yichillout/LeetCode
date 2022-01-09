package com.jasper.unionfind;

import java.util.ArrayList;
import java.util.List;

public class LC0305_NumberOfIslandsII {

    class DSU {
        int[] parent;

        public DSU(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public void union(int x, int y) {
            parent[find(x)] = find(y);
        }
    }

    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        DSU dsu = new DSU(m * n);
        boolean[][] island = new boolean[m][n];
        List<Integer> res = new ArrayList<>();

        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        int count = 0;
        for (int[] cur : positions) {
            if (island[cur[0]][cur[1]]) {
                res.add(count);
                continue;
            }

            island[cur[0]][cur[1]] = true;
            count++;
            for (int[] dir : dirs) {
                int x = cur[0] + dir[0];
                int y = cur[1] + dir[1];
                if (x < 0 || x >= m || y < 0 || y >= n || !island[x][y]) {
                    continue;
                }

                int component1 = dsu.find(cur[0] * n + cur[1]);
                int component2 = dsu.find(x * n + y);
                if (component1 != component2) {
                    dsu.union(component1, component2);
                    count--;
                }
            }

            res.add(count);
        }

        return res;
    }
}
