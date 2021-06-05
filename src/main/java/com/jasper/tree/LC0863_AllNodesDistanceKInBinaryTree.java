package com.jasper.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import com.jasper.common.TreeNode;

public class LC0863_AllNodesDistanceKInBinaryTree {

    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {

        List<Integer> result = new ArrayList<>();
        Map<Integer, Set<Integer>> map = new HashMap<>();

        build(map, root, null);

        Queue<Integer> q = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();

        for (int key : map.keySet()) {
            if (key == target.val) {
                q.offer(key);
                visited.add(key);
            }
        }

        if (q.isEmpty()) {
            return result;
        }

        int level = 0;

        if (level == K) {
            result.add(q.poll());
            return result;
        }

        while (!q.isEmpty()) {
            int size = q.size();
            level++;
            for (int i = 0; i < size; i++) {
                int val = q.poll();
                for (int next : map.get(val)) {
                    if (!visited.contains(next)) {
                        q.offer(next);
                        visited.add(next);
                        if (level == K) {
                            result.add(next);
                        }
                    }
                }
            }

            if (level == K) {
                return result;
            }
        }

        return result;
    }

    private void build(Map<Integer, Set<Integer>> map, TreeNode node, TreeNode parent) {
        if (node == null) {
            return;
        }

        if (!map.containsKey(node.val)) {
            map.put(node.val, new HashSet<Integer>());
            if (parent != null) {
                map.get(node.val).add(parent.val);
                map.get(parent.val).add(node.val);
            }
            build(map, node.left, node);
            build(map, node.right, node);
        }
    }
}
