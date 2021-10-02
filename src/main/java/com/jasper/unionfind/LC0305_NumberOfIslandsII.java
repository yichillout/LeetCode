package com.jasper.unionfind;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC0305_NumberOfIslandsII {

    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> result = new ArrayList<>();

        if (m <= 0 || n <= 0) {
            return result;
        }

        int count = 0;
        int[][] dirs = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        int[] roots = new int[m * n];
        Arrays.fill(roots, -1);

        for (int[] p : positions) {
            int root = n * p[0] + p[1];

            if (roots[root] != -1) {
                result.add(count);
                continue;
            }

            roots[root] = root;
            count++;


            for (int[] dir : dirs) {
                int x = p[0] + dir[0];
                int y = p[1] + dir[1];
                int nb = n * x + y;

                if (x < 0 || x >= m || y < 0 || y >= n || roots[nb] == -1) {
                    continue;
                }

                int rootNb = findIsland(roots, nb);
                if (root != rootNb) {
                    roots[root] = rootNb;
                    root = rootNb;
                    count--;
                }
            }

            result.add(count);
        }

        return result;
    }

    public int findIsland(int[] roots, int id) {
        while (id != roots[id]) {
            id = roots[id];
        }
        return id;
    }
}
