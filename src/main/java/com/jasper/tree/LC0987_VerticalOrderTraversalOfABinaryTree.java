package com.jasper.tree;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

import com.jasper.common.TreeNode;

public class LC0987_VerticalOrderTraversalOfABinaryTree {

    // Solution 1 : DFS + PriorityQueue
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> res = new ArrayList();

        if (root == null) {
            return res;
        }

        PriorityQueue<Point> pq = new PriorityQueue((Comparator<Point>) (p1, p2) -> {
            if (p1.x != p2.x) {
                return p1.x - p2.x;
            } else if (p1.y != p2.y) {
                return p2.y - p1.y;
            } else {
                return p1.val - p2.val;
            }
        });

        dfs(root, 0, 0, pq);

        int prev_x = Integer.MIN_VALUE;

        while (!pq.isEmpty()) {
            Point p = pq.poll();
            if (p.x > prev_x) {
                List<Integer> list = new ArrayList();
                list.add(p.val);
                res.add(list);
            } else {
                List<Integer> list = res.get(res.size() - 1);
                list.add(p.val);
            }
            prev_x = p.x;
        }

        return res;
    }

    private void dfs(TreeNode root, int x, int y, PriorityQueue<Point> pq) {
        if (root == null) {
            return;
        }

        pq.offer(new Point(x, y, root.val));
        dfs(root.left, x - 1, y - 1, pq);
        dfs(root.right, x + 1, y - 1, pq);
    }

    class Point {
        int x;
        int y;
        int val;

        Point(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }
    }
}
