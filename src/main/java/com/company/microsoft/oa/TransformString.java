package com.company.microsoft.oa;

import java.util.Stack;

//https://leetcode.com/discuss/interview-question/1463805/Microsoft-Codility-OA-or-September-2021
public class TransformString {

    private static String transform(String str) {

        Stack<Character> stack = new Stack<>();

        for (int i = str.length() - 1; i >= 0; i--) {
            char ch = str.charAt(i);
            if (!stack.isEmpty()) {
                char topChar = stack.peek();
                if ((topChar == 'A' && ch == 'B') || (topChar == 'B' && ch == 'A') || (topChar == 'C' && ch == 'D') || (topChar == 'D' && ch == 'C')) {
                    stack.pop();
                    continue;
                }
            }
            stack.push(ch);
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(transform("CBACD"));
    }
}
