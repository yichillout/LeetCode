package com.jasper.greedy;

public class LC0678_ValidParenthesisString {

    public boolean checkValidString(String s) {
        // open parentheses count in range [cmin, cmax]
        int cmin = 0;
        int cmax = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                cmax++;
                cmin++;
            } else if (c == ')') {
                cmax--;
                cmin--;
            } else if (c == '*') {
                cmax++; // if `*` become `(` then openCount++
                cmin--; // if `*` become `)` then openCount--
                // if `*` become `` then nothing happens
                // So openCount will be in new range [cmin-1, cmax+1]
            }

            if (cmax < 0) {
                return false; // Currently, don't have enough open parentheses to match close parentheses-> Invalid
            }

            // For example: ())(
            cmin = Math.max(cmin, 0);   // It's invalid if open parentheses count < 0 that's why cmin can't be negative
        }

        return cmin == 0; // Return true if can found `openCount == 0` in range [cmin, cmax]
    }
}
