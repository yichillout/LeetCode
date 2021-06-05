package com.jasper.tree;

import com.annotation.Template;
import com.jasper.common.TreeNode;

import java.util.Stack;

@Template
public class LC1028_RecoverATreeFromPreorderTraversal {

    public static TreeNode recoverFromPreorder(String S) {

        Stack<TreeNode> stack = new Stack<>();

        int index = 0;

        char[] ss = S.toCharArray();

        while (index < ss.length) {

            int level = 0;
            int val = 0;

            while (index < ss.length && ss[index] == '-') {
                level++;
                index++;
            }

            while (index < ss.length && ss[index] >= '0' && ss[index] <= '9') {
                val = val * 10 + (ss[index] - '0');
                index++;
            }

            while (stack.size() > level) {
                stack.pop();
            }

            TreeNode node = new TreeNode(val);
            if (!stack.isEmpty()) {
                if (stack.peek().left == null) {
                    stack.peek().left = node;
                } else {
                    stack.peek().right = node;
                }
            }

            stack.push(node);
        }

        while (stack.size() > 1) {
            stack.pop();
        }

        return stack.pop();
    }

    public static void main(String[] args) {
        recoverFromPreorder("1-2--3--4-5--6--7");
    }
}
