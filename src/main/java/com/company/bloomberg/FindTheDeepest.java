package com.company.bloomberg;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/discuss/interview-question/1079570/bloomberg-technical-phone-screen-swe-new-grad-2021-nyc

public class FindTheDeepest {

    public static List<String> test(String str) {
        List<String> res = new ArrayList<>();

        if (str == null || str.length() == 0) {
            return res;
        }

        int maxDepth = getMaxDepth(str);
        int depth = 0;
        StringBuilder sb = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                depth++;
                sb = new StringBuilder();
            } else if (c == ')' || c == '}' || c == ']') {
                if (depth == maxDepth) {
                    res.add(sb.toString());
                }
                sb = new StringBuilder();
                depth--;
            } else {
                sb.append(c);
            }
        }

        return res;
    }

    public static int getMaxDepth(String str) {
        int res = 0;
        int depth = 0;
        for (char c : str.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                depth++;
                if (depth > res) {
                    res = depth;
                }
            } else if (c == ')' || c == '}' || c == ']') {
                depth--;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(test("abc(def[gh[c]i[ddd]]jkl)mn[((eeee))]o"));
    }
}
