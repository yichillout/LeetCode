package com.company.bloomberg;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/discuss/interview-question/1079570/bloomberg-technical-phone-screen-swe-new-grad-2021-nyc

public class FindTheDeepest {

    public static List<String> getString(String str) {
        List<String> res = new ArrayList();
        if (str.length() == 0) {
            return res;
        }

        int count = 0;
        int max = maxCount(str);
        String tmp = "";
        for (char c : str.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                count++;
                tmp = "";
            } else if (c == ')' || c == '}' || c == ']') {
                if (count == max) {
                    res.add(tmp);
                }
                count--;
            } else {
                tmp += c;
            }
        }

        return res;

    }

    private static int maxCount(String str) {
        int count = 0;
        int max = 0;
        for (char c : str.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                count++;
                max = Math.max(count, max);
            } else if (c == ')' || c == '}' || c == ']') {

                count--;
            }

        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(getString("abc(def[gh[c]i]jkl)mno"));
    }
}
