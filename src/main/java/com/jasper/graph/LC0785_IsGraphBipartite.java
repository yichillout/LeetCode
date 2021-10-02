package com.jasper.graph;

import java.util.LinkedList;
import java.util.Queue;

public class LC0785_IsGraphBipartite {

    public boolean isBipartite(int[][] graph) {

        int N = graph.length;
        // 0: not visited;   1: red;   2: green
        int[] visited = new int[N];

        for (int i = 0; i < N; i++) {
            if (visited[i] == 0 && !isValid(i, visited, graph)) {
                return false;
            }
        }

        return true;
    }

    public boolean isValid(int start, int[] visited, int[][] graph) {
        Queue<Integer> queue = new LinkedList<>();
        int color = 1;
        int preColor = 2;

        queue.offer(start);
        visited[start] = color;

        while (!queue.isEmpty()) {
            int size = queue.size();
            preColor = color;
            color = color == 1 ? 2 : 1;

            for (int i = 0; i < size; i++) {
                int num = queue.poll();
                int[] nexts = graph[num];

                for (int j = 0; j < nexts.length; j++) {
                    if (visited[nexts[j]] == preColor) {
                        return false;
                    }

                    if (visited[nexts[j]] == 0) {
                        visited[nexts[j]] = color;
                        queue.offer(nexts[j]);
                    }
                }
            }
        }

        return true;
    }
}
