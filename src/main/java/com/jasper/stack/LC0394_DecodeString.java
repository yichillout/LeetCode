package com.jasper.stack;

import java.util.Stack;

public class LC0394_DecodeString {

    public static String decodeString(String s) {

        Stack<Integer> intStack = new Stack<>();
        Stack<StringBuilder> strStack = new Stack<>();
        StringBuilder cur = new StringBuilder();

        int num = 0;
        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                num = num * 10 + ch - '0';
            } else if (ch == '[') {
                intStack.push(num);
                strStack.push(cur);
                cur = new StringBuilder();
                num = 0;
            } else if (ch == ']') {
                StringBuilder tmp = cur;
                cur = strStack.pop();
                int count = intStack.pop();
                while (count > 0) {
                    cur.append(tmp);
                    count--;
                }
            } else {
                cur.append(ch);
            }
        }

        return cur.toString();
    }

    public static void main(String[] args) {
        String s = "3[a2[c]]";
        System.out.println(decodeString(s));

    }

}
