package com.jasper.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.jasper.common.TreeNode;

public class LC0652_FindDuplicateSubtrees {

	public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
		List<TreeNode> result = new ArrayList<>();
		Map<String, Integer> map = new HashMap<>();
		helper(result, root, map);
		return result;
	}

	private String helper(List<TreeNode> result, TreeNode node, Map<String, Integer> map) {
		if (node == null) {
			return "#";
		}

		String str = node.val + "," + helper(result, node.left, map) + "," + helper(result, node.right, map);

		if (map.containsKey(str)) {
			map.put(str, map.get(str) + 1);
			if (map.get(str) == 2) {
				result.add(node);
			}
		} else {
			map.put(str, 1);
		}

		return str;
	}
}
