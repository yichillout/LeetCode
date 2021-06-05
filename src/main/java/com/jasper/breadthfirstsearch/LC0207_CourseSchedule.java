package com.jasper.breadthfirstsearch;

import java.util.*;

public class LC0207_CourseSchedule {

	public static boolean canFinish(int numCourses, int[][] prerequisites) {

		Map<Integer, List<Integer>> courses = new HashMap<>();
		Map<Integer, Integer> indegree = new HashMap<>();

		courses = build(numCourses, prerequisites);
		indegree = getIndegree(numCourses, prerequisites);

		Queue<Integer> queue = new LinkedList<>();
		for (Integer key : indegree.keySet()) {
			if (indegree.get(key) == 0) {
				queue.offer(key);
			}
		}

		int count = 0;
		while (!queue.isEmpty()) {
			int course = queue.poll();
			count++;
			List<Integer> list = courses.get(course);
			for (int i = 0; i < list.size(); i++) {
				indegree.put(list.get(i), indegree.get(list.get(i)) - 1);
				if (indegree.get(list.get(i)) == 0) {
					queue.offer(list.get(i));
				}
			}
		}

		return count == numCourses;
	}

	private static Map<Integer, List<Integer>> build(int numCourses, int[][] prerequisites) {
		Map<Integer, List<Integer>> courses = new HashMap<>();
		for (int i = 0; i < numCourses; i++) {
			courses.put(i, new ArrayList<Integer>());
		}
		for (int[] pre : prerequisites) {
			courses.get(pre[1]).add(pre[0]);
		}
		return courses;
	}

	private static Map<Integer, Integer> getIndegree(int numCourses, int[][] prerequisites) {
		Map<Integer, Integer> indegree = new HashMap<>();
		for (int i = 0; i < numCourses; i++) {
			indegree.put(i, 0);
		}
		for (int[] pre : prerequisites) {
			indegree.put(pre[0], indegree.get(pre[0]) + 1);
		}
		return indegree;
	}

	public static void main(String[] args) {
		int[][] prerequisites = { { 0, 2 }, { 0, 1 }, { 3, 2 }, { 4, 3 } };
		System.out.println(canFinish(5, prerequisites));

	}
}
