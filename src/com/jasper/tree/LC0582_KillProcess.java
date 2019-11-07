package com.jasper.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class LC0582_KillProcess {

	public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {

		List<Integer> result = new ArrayList<>();
		Map<Integer, Set<Integer>> map = new HashMap<>();

		for (int i = 0; i < ppid.size(); i++) {
			map.put(ppid.get(i), new HashSet<Integer>());
			map.put(pid.get(i), new HashSet<Integer>());
		}

		for (int i = 0; i < ppid.size(); i++) {
			map.get(ppid.get(i)).add(pid.get(i));
		}

		Queue<Integer> q = new LinkedList<>();

		q.offer(kill);
		result.add(kill);

		while (!q.isEmpty()) {
			int num = q.poll();
			Set<Integer> children = map.get(num);

			for (int child : children) {
				q.offer(child);
				result.add(child);
			}
		}

		return result;

	}
}
