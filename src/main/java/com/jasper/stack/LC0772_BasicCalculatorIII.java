package com.jasper.stack;

import java.util.Stack;

public class LC0772_BasicCalculatorIII {

    int i = 0;

    public int calculate(String s) {

        Stack<Integer> stack = new Stack<>();

        char operator = '+';

        int num = 0;

        while (i < s.length()) {
            char c = s.charAt(i++);

            if (c >= '0' && c <= '9') {
                num = num * 10 + (c - '0');
            }

            if (c == '(') {
                num = calculate(s);
            }

            if (i == s.length() || c == '+' || c == '-' || c == '*' || c == '/' || c == ')') {
                if (operator == '+') {
                    stack.push(num);
                } else if (operator == '-') {
                    stack.push(-num);
                } else if (operator == '*') {
                    stack.push(stack.pop() * num);
                } else if (operator == '/') {
                    stack.push(stack.pop() / num);
                }

                operator = c;
                num = 0;
            }

            if (c == ')') {
                break;
            }
        }

        int sum = 0;

        while (!stack.isEmpty()) {
            sum += stack.pop();
        }

        return sum;
    }
}
