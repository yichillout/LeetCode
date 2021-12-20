package com.jasper.tree;

import java.util.Stack;

/**
 * This is the interface for the expression tree Node.
 * You should not remove it, and you can define some classes to implement it.
 */

abstract class Node {
    public abstract int evaluate();
    // define your fields here
};


/**
 * This is the TreeBuilder class.
 * You can treat it as the driver code that takes the postinfix input
 * and returns the expression tree represnting it as a Node.
 */

class TreeBuilder {

    static class TreeNode extends Node {
        String val;
        TreeNode left;
        TreeNode right;

        public TreeNode(String val) {
            this.val = val;
        }

        public int evaluate() {
            return TreeNode.dfs(this);
        }

        public static int dfs(TreeNode node) {
            if (node.left == null && node.right == null) {
                return Integer.valueOf(node.val);
            }

            int l = dfs(node.left);
            int r = dfs(node.right);

            if (node.val.equals("+")) {
                return l + r;
            } else if (node.val.equals("-")) {
                return l - r;
            } else if (node.val.equals("*")) {
                return l * r;
            } else {
                return l / r;
            }
        }
    }

    Node buildTree(String[] postfix) {
        Stack<TreeNode> stack = new Stack<>();
        String operators = "+-*/";

        for (String str : postfix) {
            if (operators.contains(str)) {
                TreeNode newNode = new TreeNode(str);
                newNode.right = stack.pop();
                newNode.left = stack.pop();
                stack.push(newNode);
            } else {
                stack.push(new TreeNode(str));
            }
        }

        return stack.peek();
    }
};


/**
 * Your TreeBuilder object will be instantiated and called as such:
 * TreeBuilder obj = new TreeBuilder();
 * Node expTree = obj.buildTree(postfix);
 * int ans = expTree.evaluate();
 */

public class LC1628_DesignAnExpressionTreeWithEvaluateFunction {
}
