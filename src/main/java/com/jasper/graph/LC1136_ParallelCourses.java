package com.jasper.graph;

import java.util.*;

public class LC1136_ParallelCourses {

    public int minimumSemesters(int n, int[][] relations) {

        Map<Integer, Integer> preMap = buildPreMap(n, relations);
        Map<Integer, List<Integer>> neighbors = buildNeighbors(n, relations);

        Queue<Integer> queue = new LinkedList<>();

        int count = 0;

        for (Map.Entry<Integer, Integer> entry : preMap.entrySet()) {
            if (entry.getValue() == 0) {
                queue.offer(entry.getKey());
                count++;
            }
        }

        if (queue.isEmpty()) {
            return -1;
        }

        int level = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            level++;
            for (int i = 0; i < size; i++) {
                int cur = queue.poll();
                if (neighbors.get(cur) != null) {
                    for (int next : neighbors.get(cur)) {
                        preMap.put(next, preMap.get(next) - 1);
                        if (preMap.get(next) == 0) {
                            queue.offer(next);
                            count++;
                        }
                    }
                }
            }
        }

        return count == n ? level : -1;
    }

    public Map<Integer, List<Integer>> buildNeighbors(int n, int[][] relations) {

        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int[] relation : relations) {
            if (!map.containsKey(relation[0])) {
                map.put(relation[0], new ArrayList<>());
            }
            map.get(relation[0]).add(relation[1]);
        }

        return map;
    }

    public Map<Integer, Integer> buildPreMap(int n, int[][] relations) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 1; i <= n; i++) {
            map.put(i, 0);
        }

        for (int[] relation : relations) {
            map.put(relation[1], map.get(relation[1]) + 1);
        }

        return map;
    }
}
