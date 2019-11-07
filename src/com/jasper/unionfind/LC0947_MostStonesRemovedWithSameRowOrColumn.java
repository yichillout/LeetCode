package com.jasper.unionfind;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LC0947_MostStonesRemovedWithSameRowOrColumn {

	// Solution 1 : Union Find
	public int removeStones(int[][] stones) {

		Map<String, String> map = new HashMap<>();
		int[] count = { stones.length };

		for (int[] stone : stones) {
			String tmp = stone[0] + " " + stone[1];
			map.put(tmp, tmp);
		}

		for (int[] stone1 : stones) {
			String str1 = stone1[0] + " " + stone1[1];
			for (int[] stone2 : stones) {
				if (stone1[0] == stone2[0] || stone1[1] == stone2[1]) {
					String str2 = stone2[0] + " " + stone2[1];
					union(map, str1, str2, count);
				}
			}
		}

		return stones.length - count[0];
	}

	private void union(Map<String, String> map, String str1, String str2, int[] count) {
		String str1P = find(map, str1);
		String str2P = find(map, str2);
		if (!str1P.equals(str2P)) {
			map.put(str1P, str2P);
			count[0]--;
		}
	}

	private String find(Map<String, String> map, String str) {
		if (!map.get(str).equals(str)) {
			map.put(str, find(map, map.get(str)));
		}
		return map.get(str);
	}

	// Solution 2 : DFS
	public int removeStones2(int[][] stones) {
		Set<int[]> visited = new HashSet<>();
		int numOfIslands = 0;
		for (int[] s1 : stones) {
			if (!visited.contains(s1)) {
				dfs(s1, visited, stones);
				numOfIslands++;
			}
		}
		return stones.length - numOfIslands;
	}

	private void dfs(int[] s1, Set<int[]> visited, int[][] stones) {
		visited.add(s1);
		for (int[] s2 : stones) {
			if (!visited.contains(s2)) {
				if (s1[0] == s2[0] || s1[1] == s2[1])
					dfs(s2, visited, stones);
			}
		}
	}
}
