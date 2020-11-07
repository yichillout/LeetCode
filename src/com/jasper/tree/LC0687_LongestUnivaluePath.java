package com.jasper.tree;

import com.jasper.common.TreeNode;

public class LC0687_LongestUnivaluePath {

    class Result {

        int max;
        int lineMax;

        public Result(int max, int lineMax) {
            this.max = max;
            this.lineMax = lineMax;
        }

    }

    public int longestUnivaluePath(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return dfs(root).max - 1;
    }

    public Result dfs(TreeNode node) {

        if (node == null) {
            return new Result(0, 0);
        }

        Result left = dfs(node.left);
        Result right = dfs(node.right);

        int max = 1;
        int lineMax = 1;
        int lineLeftMax = 0;
        int lineRightMax = 0;

        if (node.left != null && node.left.val == node.val) {
            lineLeftMax = left.lineMax;
        }

        if (node.right != null && node.right.val == node.val) {
            lineRightMax = right.lineMax;
        }

        lineMax += Math.max(lineLeftMax, lineRightMax);

        max = Math.max(max, Math.max(left.max, right.max));
        max = Math.max(max, 1 + lineLeftMax + lineRightMax);

        return new Result(max, lineMax);
    }
}
