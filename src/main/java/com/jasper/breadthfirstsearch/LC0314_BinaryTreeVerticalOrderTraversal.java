package com.jasper.breadthfirstsearch;

import com.jasper.common.TreeNode;

import java.util.*;

public class LC0314_BinaryTreeVerticalOrderTraversal {

    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Map<Integer, List<Integer>> colToValues = new HashMap<>();
        Map<TreeNode, Integer> NodeToCol = new HashMap<>();
        int minCol = Integer.MAX_VALUE;

        Queue<TreeNode> q = new LinkedList<>();

        if (root != null) {
            q.offer(root);
            NodeToCol.put(root, 0);
        }

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = q.poll();
                int col = NodeToCol.get(cur);

                if (!colToValues.containsKey(col)) {
                    colToValues.put(col, new ArrayList<>());
                }
                colToValues.get(col).add(cur.val);

                if (cur.left != null) {
                    NodeToCol.put(cur.left, col - 1);
                    q.offer(cur.left);
                }

                if (cur.right != null) {
                    NodeToCol.put(cur.right, col + 1);
                    q.offer(cur.right);
                }

                minCol = Math.min(minCol, col);
            }
        }

        int i = minCol;
        while (colToValues.containsKey(i)) {
            res.add(colToValues.get(i));
            i++;
        }

        return res;
    }
}
