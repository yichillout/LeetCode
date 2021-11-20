package com.jasper.breadthfirstsearch;

import java.util.*;

public class LC0210_CourseScheduleII {

    /**
     * @param numCourses
     * @param prerequisites
     * @return Input: numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
     * 0 -> 1
     * 0 -> 2
     * 1 -> 3
     * 2 -> 3
     * preMap: {0:0,1:1,2:1,3:2}
     * nextMap: {0:[1,2],1:[3],2:[3],3:[]}
     * Output: [0,2,1,3]
     */

    public int[] findOrder(int numCourses, int[][] prerequisites) {

        Map<Integer, List<Integer>> courseMap = buildMap(numCourses, prerequisites);
        Map<Integer, Integer> inDegrees = buildInDegrees(numCourses, prerequisites);

        int[] result = new int[numCourses];

        Queue<Integer> queue = new LinkedList<>();

        int index = 0;
        for (Map.Entry<Integer, Integer> entry : inDegrees.entrySet()) {
            if (entry.getValue() == 0) {
                result[index] = entry.getKey();
                queue.offer(result[index]);
                index++;
            }
        }

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int course = queue.poll();
                List<Integer> nexts = courseMap.get(course);

                for (int next : nexts) {
                    inDegrees.put(next, inDegrees.get(next) - 1);
                    if (inDegrees.get(next) == 0) {
                        queue.offer(next);
                        result[index] = next;
                        index++;
                    }
                }
            }
        }

        if (index != numCourses) {
            return new int[]{};
        }

        return result;
    }

    public Map<Integer, List<Integer>> buildMap(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = numCourses - 1; i >= 0; i--) {
            map.put(i, new ArrayList<>());
        }

        for (int[] p : prerequisites) {
            map.get(p[1]).add(p[0]);
        }

        return map;
    }

    public Map<Integer, Integer> buildInDegrees(int numCourses, int[][] prerequisites) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = numCourses - 1; i >= 0; i--) {
            map.put(i, 0);
        }

        for (int[] p : prerequisites) {
            map.put(p[0], map.get(p[0]) + 1);
        }

        return map;
    }
}
