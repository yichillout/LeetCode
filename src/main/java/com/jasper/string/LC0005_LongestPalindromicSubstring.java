package com.jasper.string;

public class LC0005_LongestPalindromicSubstring {

    public String longestPalindrome(String s) {

        String result = s.substring(0, 1);

        for (int i = 0; i < s.length() - 1; i++) {
            String tmp = helper(s, i, i);

            if (tmp != null && tmp.length() > result.length()) {
                result = tmp;
            }

            tmp = helper(s, i, i + 1);

            if (tmp != null && tmp.length() > result.length()) {
                result = tmp;
            }
        }

        return result;
    }

    public String helper(String s, int l, int r) {
        boolean flag = false;

        while (l >= 0 && r < s.length()) {
            if (s.charAt(l) == s.charAt(r)) {
                flag = true;
            } else {
                break;
            }

            l--;
            r++;
        }

        if (flag) {
            return s.substring(l + 1, r);
        }

        return null;
    }
}
