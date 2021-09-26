package com.jasper.breadthfirstsearch;

import com.jasper.common.TreeNode;

import java.util.*;

public class LC0314_BinaryTreeVerticalOrderTraversal {

    class Node {

        TreeNode treeNode;
        int index;

        public Node(TreeNode treeNode, int index) {
            this.treeNode = treeNode;
            this.index = index;
        }

    }

    public List<List<Integer>> verticalOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Queue<Node> queue = new LinkedList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        int min = 0;
        int max = 0;

        queue.offer(new Node(root, 0));
        map.put(0, new ArrayList<Integer>(Arrays.asList(root.val)));

        while (!queue.isEmpty()) {

            int size = queue.size();

            for (int i = 0; i < size; i++) {

                Node node = queue.poll();

                if (node.treeNode.left != null) {
                    queue.offer(new Node(node.treeNode.left, node.index - 1));
                    min = Math.min(node.index - 1, min);

                    if (!map.containsKey(node.index - 1)) {
                        map.put(node.index - 1, new ArrayList<Integer>(Arrays.asList(node.treeNode.left.val)));
                    } else {
                        map.get(node.index - 1).add(node.treeNode.left.val);
                    }
                }

                if (node.treeNode.right != null) {
                    queue.offer(new Node(node.treeNode.right, node.index + 1));
                    max = Math.max(node.index + 1, max);

                    if (!map.containsKey(node.index + 1)) {
                        map.put(node.index + 1, new ArrayList<Integer>(Arrays.asList(node.treeNode.right.val)));
                    } else {
                        map.get(node.index + 1).add(node.treeNode.right.val);
                    }
                }
            }
        }


        for (int i = min; i <= max; i++) {
            result.add(map.get(i));
        }


        return result;
    }
}
