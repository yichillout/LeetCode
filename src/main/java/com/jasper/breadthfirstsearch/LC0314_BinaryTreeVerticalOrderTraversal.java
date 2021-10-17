package com.jasper.breadthfirstsearch;

import com.jasper.common.TreeNode;

import java.util.*;

public class LC0314_BinaryTreeVerticalOrderTraversal {

    public List<List<Integer>> verticalOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, List<Integer>> hm = new HashMap<>();
        Map<TreeNode, Integer> nodeToIndex = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();

        if (root == null) {
            return result;
        }

        queue.offer(root);
        hm.put(0, new ArrayList<>());
        hm.get(0).add(root.val);
        nodeToIndex.put(root, 0);
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                int index = nodeToIndex.get(node);

                if (node.left != null) {
                    int leftIndex = index - 1;
                    if (!hm.containsKey(leftIndex)) {
                        hm.put(leftIndex, new ArrayList<>());
                    }
                    queue.offer(node.left);
                    hm.get(leftIndex).add(node.left.val);
                    nodeToIndex.put(node.left, leftIndex);
                }


                if (node.right != null) {
                    int rightIndex = index + 1;
                    if (!hm.containsKey(rightIndex)) {
                        hm.put(rightIndex, new ArrayList<>());
                    }
                    queue.offer(node.right);
                    hm.get(rightIndex).add(node.right.val);
                    nodeToIndex.put(node.right, rightIndex);
                }
            }
        }

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int num : hm.keySet()) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        for (int i = min; i <= max; i++) {
            List<Integer> list = hm.get(i);
            result.add(list);
        }

        return result;
    }
}
