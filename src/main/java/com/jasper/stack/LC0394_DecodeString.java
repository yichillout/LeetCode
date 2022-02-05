package com.jasper.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LC0394_DecodeString {

    // solution 1 : one stack
    public static String decodeString1(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ']') {
                List<Character> tmp = new ArrayList<>();

                while (stack.peek() != '[') {
                    tmp.add(stack.pop());
                }

                stack.pop();

                int base = 1;
                int num = 0;
                while (!stack.isEmpty() && stack.peek() >= '0' && stack.peek() <= '9') {
                    num += (stack.pop() - '0') * base;
                    base *= 10;
                }

                while (num != 0) {
                    for (int j = tmp.size() - 1; j >= 0; j--) {
                        stack.push(tmp.get(j));
                    }
                    num--;
                }
            } else {
                stack.push(s.charAt(i));
            }
        }

        char[] result = new char[stack.size()];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }

        return new String(result);
    }

    // solution 2 : two stack
    String decodeString2(String s) {
        Stack<Integer> countStack = new Stack<>();
        Stack<StringBuilder> stringStack = new Stack<>();
        StringBuilder currentString = new StringBuilder();
        int k = 0;
        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                k = k * 10 + ch - '0';
            } else if (ch == '[') {
                countStack.push(k);
                stringStack.push(currentString);
                currentString = new StringBuilder();
                k = 0;
            } else if (ch == ']') {
                StringBuilder decodedString = stringStack.pop();
                for (int currentK = countStack.pop(); currentK > 0; currentK--) {
                    decodedString.append(currentString);
                }
                currentString = decodedString;
            } else {
                currentString.append(ch);
            }
        }
        return currentString.toString();
    }

    public static void main(String[] args) {
        String s = "3[a2[c]]";
        System.out.println(decodeString1(s));

    }

}
