package com.jasper.stack;

import com.jasper.common.TreeNode;

import java.util.Stack;

public class LC0536_ConstructBinaryTreeFromString {

    public TreeNode str2tree(String s) {

        Stack<TreeNode> stack = new Stack<>();
        TreeNode parent = null;
        TreeNode curNode = null;
        int sign = 1;
        int si = 0;

        while (si < s.length()) {
            if (s.charAt(si) == ')') {
                curNode = stack.pop();
                parent = stack.peek();
                if (parent.left != null) {
                    parent.right = curNode;
                } else {
                    parent.left = curNode;
                }
                si++;
            } else if (s.charAt(si) == '-') {
                sign = -1;
                si++;
            } else if (s.charAt(si) == '(') {
                si++;
            } else {
                int num = 0;
                while (si < s.length() && s.charAt(si) >= '0' && s.charAt(si) <= '9') {
                    num = num * 10 + s.charAt(si) - '0';
                    si++;
                }
                num *= sign;
                sign = 1;
                stack.push(new TreeNode(num));
            }
        }

        // in case of input is only one node
        if (!stack.isEmpty()) {
            return stack.peek();
        }

        return parent;
    }
}
