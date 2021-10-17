package com.jasper.dynamicprogramming;

public class LC0647_PalindromicSubstrings {

    // solution 1 : DP TODO


    // solution 2
    public int countSubstrings2(String s) {
        char[] ss = s.toCharArray();
        int sum = 0;
        for (int i = 0; i < ss.length; i++) {
            sum += getNumberOfPalindromic(ss, i, i);
            sum += getNumberOfPalindromic(ss, i, i + 1);
        }
        return sum;
    }

    public int getNumberOfPalindromic(char[] ss, int x, int y) {
        int l = x;
        int r = y;
        int count = 0;
        while (l >= 0 && r < ss.length) {
            if (ss[l] == ss[r]) {
                l--;
                r++;
                count++;
            } else {
                break;
            }
        }
        return count;
    }
}
