package com.jasper.tree;

import java.util.*;

import com.jasper.common.TreeNode;

public class LC0508_MostFrequentSubtreeSum {
	public int[] findFrequentTreeSum(TreeNode root) {
		Map<Integer, Integer> map = new HashMap<>();

		helper(map, root);

		int maxFreq = Integer.MIN_VALUE;
		int count = 0;

		for (int key : map.keySet()) {
			if (map.get(key) > maxFreq) {
				maxFreq = map.get(key);
				count = 1;
			} else if (map.get(key) == maxFreq) {
				count++;
			}
		}

		int[] res = new int[count];
		int index = 0;
		for (int key : map.keySet()) {
			if (map.get(key) == maxFreq) {
				res[index++] = key;
			}
		}

		return res;
	}

	private int helper(Map<Integer, Integer> map, TreeNode node) {
		if (node == null) {
			return 0;
		}

		int left = helper(map, node.left);
		int right = helper(map, node.right);

		int sum = node.val + left + right;

		if (!map.containsKey(sum)) {
			map.put(sum, 1);
		} else {
			map.put(sum, map.get(sum) + 1);
		}

		return sum;
	}
}
