package com.jasper.breadthfirstsearch;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class LC0301_RemoveInvalidParentheses {
	public List<String> removeInvalidParentheses(String s) {
		List<String> res = new ArrayList<>();
		if (s == null) {
			return res;
		}
		Queue<String> queue = new LinkedList<>();
		Set<String> visited = new HashSet<>();
		queue.offer(s);
		boolean foundResult = false;

		while (!queue.isEmpty()) {
			s = queue.poll();
			if (isValid(s)) {
				res.add(s);
				foundResult = true;
			}
			if (foundResult) {
				continue;
			}
			for (int i = 0; i < s.length(); i++) {
				char c = s.charAt(i);
				if (c == '(' || c == ')') {
					String t = s.substring(0, i) + s.substring(i + 1);
					if (!visited.contains(t)) {
						queue.offer(t);
						visited.add(t);
					}
				}
			}
		}

		return res;
	}

	private boolean isValid(String s) {
		int leftCount = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '(') {
				leftCount++;
			} else if (c == ')') {
				leftCount--;
			}
			if (leftCount < 0) {
				return false;
			}
		}

		return leftCount == 0;
	}
}
