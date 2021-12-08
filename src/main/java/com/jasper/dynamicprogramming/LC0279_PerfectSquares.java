package com.jasper.dynamicprogramming;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class LC0279_PerfectSquares {

    // solution 1 : BFS
    public int numSquares1(int n) {
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();

        if (n > 0) {
            queue.offer(n);
            visited.add(n);
        }

        int level = 0;

        while (!queue.isEmpty()) {
            level++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int val = queue.poll();
                for (int j = 1; j <= Math.sqrt(val); j++) {
                    if (val - (j * j) == 0) {
                        return level;
                    }
                    if (!visited.contains(val - (j * j))) {
                        queue.offer(val - (j * j));
                        visited.add(val - (j * j));
                    }
                }
            }
        }

        return level;
    }

    // solution 2 : DP
    public int numSquares2(int n) {
        if (n == 0) {
            return 0;
        }

        int[] f = new int[n + 1];

        f[0] = 0;

        for (int i = 1; i <= n; i++) {
            f[i] = Integer.MAX_VALUE;
            for (int j = 1; j <= i; j++) { // j is from 1 to i
                if (i - j * j >= 0) {
                    f[i] = Math.min(f[i], f[i - j * j] + 1);
                }
            }
        }

        return f[n];
    }
}
