package com.jasper.tree;

import com.common.TreeNode;

public class LC0865_SmallestSubtreeWithAllTheDeepestNodes {

    class RT {
        int depth;
        TreeNode node;

        public RT(int dept, TreeNode node) {
            this.depth = dept;
            this.node = node;
        }
    }

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        return height(root).node;
    }

    private RT height(TreeNode root) {
        if (root == null) {
            return new RT(0, null);
        }

        RT left = height(root.left);
        RT right = height(root.right);

        int lDepth = left.depth;
        int rDepth = right.depth;
        if (lDepth == rDepth) {
            return new RT(lDepth + 1, root);
        } else if (lDepth < rDepth) {
            return new RT(rDepth + 1, right.node);
        } else {
            return new RT(lDepth + 1, left.node);
        }
    }
}
