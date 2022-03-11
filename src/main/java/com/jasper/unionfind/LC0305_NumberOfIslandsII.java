package com.jasper.unionfind;

import java.util.ArrayList;
import java.util.List;

public class LC0305_NumberOfIslandsII {

    class UF {

        int[] parents;

        public UF(int n) {
            parents = new int[n];
            for (int i = 0; i < n; i++) {
                parents[i] = i;
            }
        }

        public int find(int x) {
            if (parents[x] == x) {
                return x;
            }

            parents[x] = find(parents[x]);
            return parents[x];
        }

        public void union(int x, int y) {
            int p1 = find(x);
            int p2 = find(y);
            parents[p1] = p2;
        }
    }

    public List<Integer> numIslands2(int m, int n, int[][] positions) {

        List<Integer> res = new ArrayList<>();

        boolean[][] isLand = new boolean[m][n];
        UF uf = new UF(m * n);
        int count = 0;

        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        for (int[] p : positions) {
            if (isLand[p[0]][p[1]]) {
                res.add(count);
                continue;
            }

            isLand[p[0]][p[1]] = true;
            count++;

            for (int i = 0; i < dirs.length; i++) {
                int x = p[0] + dirs[i][0];
                int y = p[1] + dirs[i][1];
                if (x >= 0 && x < m && y >= 0 && y < n && isLand[x][y]) {
                    int component1 = uf.find(p[0] * n + p[1]);
                    int component2 = uf.find(x * n + y);
                    if (component1 != component2) {
                        /**
                         *  x x x      x x x
                         *  x   x ==>  x x x
                         *    x          x
                         **/
                        uf.union(component1, component2);
                        count--;
                    }
                }
            }
            res.add(count);
        }

        return res;
    }
}
