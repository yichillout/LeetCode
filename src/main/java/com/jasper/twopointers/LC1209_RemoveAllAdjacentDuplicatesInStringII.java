package com.jasper.twopointers;

import java.util.Stack;

public class LC1209_RemoveAllAdjacentDuplicatesInStringII {

    public String removeDuplicates(String s, int k) {
        Stack<Character> stack = new Stack<>();
        Stack<Integer> stackCount = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (stack.isEmpty() || stack.peek() != s.charAt(i)) {
                stack.push(s.charAt(i));
                stackCount.push(1);
            } else {
                if (stackCount.peek() == k - 1) {
                    stack.pop();
                    stackCount.pop();
                } else {
                    stackCount.push(stackCount.pop() + 1);
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        while (!stack.isEmpty()) {
            int count = stackCount.pop();
            char c = stack.pop();
            while (count > 0) {
                sb.append(c);
                count--;
            }
        }

        return sb.reverse().toString();
    }
}
