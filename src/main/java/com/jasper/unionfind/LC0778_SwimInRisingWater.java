package com.jasper.unionfind;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class LC0778_SwimInRisingWater {

    // solution 1 : heap
    public int swimInWater1(int[][] grid) {
        int N = grid.length;
        Set<Integer> seen = new HashSet();
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((k1, k2) ->
                grid[k1 / N][k1 % N] - grid[k2 / N][k2 % N]);
        pq.offer(0);
        int ans = 0;

        int[] dr = new int[]{1, -1, 0, 0};
        int[] dc = new int[]{0, 0, 1, -1};

        while (!pq.isEmpty()) {
            int k = pq.poll();
            int r = k / N, c = k % N;
            ans = Math.max(ans, grid[r][c]);
            if (r == N - 1 && c == N - 1) {
                return ans;
            }

            for (int i = 0; i < 4; ++i) {
                int cr = r + dr[i], cc = c + dc[i];
                int ck = cr * N + cc;
                if (0 <= cr && cr < N && 0 <= cc && cc < N && !seen.contains(ck)) {
                    pq.offer(ck);
                    seen.add(ck);
                }
            }
        }

        throw null;
    }


    // solution 2
    class UF {
        int[] id;

        public UF(int N) {
            id = new int[N];
            for (int i = 0; i < N; i++) {
                id[i] = i;
            }
        }

        public int root(int i) {
            while (i != id[i]) {
                id[i] = id[id[i]];
                i = id[i];
            }
            return i;
        }

        public boolean isConnected(int p, int q) {
            return root(p) == root(q);
        }

        public void union(int p, int q) {
            if (isConnected(p, q)) {
                return;
            }
            id[root(p)] = root(q);
        }
    }

    public int swimInWater2(int[][] grid) {
        int N = grid.length;
        UF uf = new UF(N * N);
        int time = 0;
        while (!uf.isConnected(0, N * N - 1)) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (grid[i][j] > time) {
                        continue;
                    }

                    if (i < N - 1 && grid[i + 1][j] <= time) {
                        uf.union(i * N + j, i * N + j + N);
                    }

                    if (j < N - 1 && grid[i][j + 1] <= time) {
                        uf.union(i * N + j, i * N + j + 1);
                    }
                }
            }
            time++;
        }

        return 0 == N * N - 1 ? 0 : time - 1; // [[0]]
    }
}
