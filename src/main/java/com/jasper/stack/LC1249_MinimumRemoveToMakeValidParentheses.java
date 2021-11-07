package com.jasper.stack;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class LC1249_MinimumRemoveToMakeValidParentheses {

    public String minRemoveToMakeValid(String s) {

        Stack<Character> stack = new Stack<>();
        Stack<Integer> stackIndex = new Stack<>(); // to memorize the index of '(' or ')' not to put into result

        char[] ss = s.toCharArray();

        for (int i = 0; i < ss.length; i++) {
            if (ss[i] != '(' && ss[i] != ')') {
                continue;
            }

            if (stack.isEmpty()) {
                stack.push(ss[i]);
                stackIndex.push(i);
            } else {
                if (ss[i] == ')' && stack.peek() == '(') {
                    stack.pop();
                    stackIndex.pop();
                } else {
                    stack.push(ss[i]);
                    stackIndex.push(i);
                }
            }
        }

        Set<Integer> set = new HashSet<>();
        while (!stackIndex.isEmpty()) {
            set.add(stackIndex.pop());
        }

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < ss.length; i++) {
            if (set.contains(i)) {
                continue;
            }
            builder.append(ss[i]);
        }

        return builder.toString();
    }
}
