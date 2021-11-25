package com.jasper.backtracking;

public class LC1849_SplittingAStringIntoDescendingConsecutiveValues {

    public boolean splitString(String s) {
        return helper(s, 0, -1, 0);
    }

    public boolean helper(String s, int start, long prev, int count) {
        if (start == s.length() && count >= 2) {
            return true;
        }

        boolean result = false;
        for (int i = start + 1; i <= s.length(); i++) {
            long num = getNum(s.substring(start, i));
            if (prev == -1 || num == prev - 1) {
                result |= helper(s, i, num, count + 1);
            }
        }

        return result;
    }

    public long getNum(String str) {
        long num = 0;
        for (int i = 0; i < str.length(); i++) {
            num = num * 10 + str.charAt(i) - '0';
        }
        return num;
    }
}
