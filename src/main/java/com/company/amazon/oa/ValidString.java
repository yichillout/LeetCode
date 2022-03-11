package com.company.amazon.oa;

import java.util.Stack;

public class ValidString {

    static boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for (char c : s.toCharArray()) {
            if (st.isEmpty()) {
                st.push(c);
            } else if (st.peek() == c) {
                st.pop();
            } else {
                st.push(c);
            }
        }
        return st.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("XY"));
    }
}
