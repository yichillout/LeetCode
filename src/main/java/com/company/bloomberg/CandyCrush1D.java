package com.company.bloomberg;

import java.util.Stack;

public class CandyCrush1D {

    public String solution(String s) {
        Stack<Character> stack = new Stack<>();
        Stack<Integer> stackCount = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (stack.isEmpty() || stack.peek() != s.charAt(i)) {
                stack.push(s.charAt(i));
                stackCount.push(1);
            } else {
                if (stackCount.peek() == 3 - 1) {
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

    public static void main(String[] args) {
        CandyCrush1D solution = new CandyCrush1D();
        System.out.println(solution.solution("aaabbbc"));
        System.out.println(solution.solution("aabbbacd"));
        System.out.println(solution.solution("aabbccddeeedcba"));
        System.out.println(solution.solution("aaabbbacd"));
    }
}