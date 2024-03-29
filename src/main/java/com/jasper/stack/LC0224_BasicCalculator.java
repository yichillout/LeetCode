package com.jasper.stack;

import java.util.Stack;

public class LC0224_BasicCalculator {

    // solution 1

    int i = 0;

    public int calculate1(String s) {

        Stack<Integer> stack = new Stack<>();

        int num = 0;
        char operator = '+';

        while (i < s.length()) {
            char c = s.charAt(i);
            i++;

            if (c == '(') {
                num = calculate1(s);
            }

            if (c >= '0' && c <= '9') {
                num = num * 10 + c - '0';
            }

            if (c == '+' || c == '-' || c == ')' || i == s.length()) {
                if (operator == '+') {
                    stack.push(num);
                } else if (operator == '-') {
                    stack.push(-num);
                }

                operator = c;
                num = 0;
            }

            if (c == ')') {
                break;
            }
        }

        int res = 0;
        while (!stack.isEmpty()) {
            res += stack.pop();
        }

        return res;
    }

    // solution 2
    public int calculate2(String s) {

        Stack<Integer> stack = new Stack<>();
        int result = 0;
        int number = 0;
        int sign = 1;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                number = 10 * number + (c - '0');
            } else if (c == '+') {
                result += sign * number;
                number = 0;
                sign = 1;
            } else if (c == '-') {
                result += sign * number;
                number = 0;
                sign = -1;
            } else if (c == '(') {
                //we push the result first, then sign;
                stack.push(result);
                stack.push(sign);
                //reset the sign and result for the value in the parenthesis
                sign = 1;
                result = 0;
            } else if (c == ')') {
                result += sign * number;
                number = 0;
                result *= stack.pop();    //stack.pop() is the sign before the parenthesis
                result += stack.pop();    //stack.pop() now is the result calculated before the parenthesis
            }
        }

        if (number != 0) {
            result += sign * number;
        }

        return result;
    }
}
