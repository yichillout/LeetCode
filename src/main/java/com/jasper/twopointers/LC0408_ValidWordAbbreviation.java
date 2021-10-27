package com.jasper.twopointers;

public class LC0408_ValidWordAbbreviation {

    public boolean validWordAbbreviation(String word, String abbr) {

        char[] w = word.toCharArray();
        char[] a = abbr.toCharArray();

        int j = 0;
        int num = 0;

        for (char c : a) {
            if (c == '0' && num == 0) {
                return false;
            }

            if (c <= '9' && c >= '0') {
                num = num * 10 + c - '0';
            } else {
                j += num;
                if (j >= w.length || w[j] != c) {
                    return false;
                }
                j++;
                num = 0;
            }
        }

        return j + num == w.length;
    }
}
