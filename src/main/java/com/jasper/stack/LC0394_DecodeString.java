package com.jasper.stack;

import java.util.Stack;

public class LC0394_DecodeString {

    public static String decodeString(String s) {

        Stack<Integer> intStack = new Stack<>();
        Stack<StringBuilder> strStack = new Stack<>();
        StringBuilder cur = new StringBuilder();

        int count = 0;
        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                count = count * 10 + ch - '0';
            } else if (ch == '[') {
                intStack.push(count);
                strStack.push(cur);
                cur = new StringBuilder();
                count = 0;
            } else if (ch == ']') {
                StringBuilder tmp = cur;
                cur = strStack.pop();
                for (count = intStack.pop(); count > 0; count--) {
                    cur.append(tmp);
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
