package com.jasper.stack;

import java.util.*;

public class LC0150_EvaluateReversePolishNotation {

    public int evalRPN(String[] tokens) {

        if (tokens == null || tokens.length == 0)
            return 0;

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < tokens.length; i++) {
            String token = tokens[i];
            if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                int num1 = stack.pop();
                int num2 = stack.pop();

                if (token.equals("+")) {
                    stack.push(num2 + num1);
                } else if (token.equals("-")) {
                    stack.push(num2 - num1);
                } else if (token.equals("*")) {
                    stack.push(num2 * num1);
                } else {
                    stack.push(num2 / num1);
                }
            } else {
                stack.push(Integer.parseInt(token));
            }
        }

        return stack.pop();
    }

}
