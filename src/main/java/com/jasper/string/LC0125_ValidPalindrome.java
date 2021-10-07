package com.jasper.string;

public class LC0125_ValidPalindrome {

    public boolean isPalindrome(String s) {
        if (s.isEmpty()) {
            return true;
        }

        int l = 0;
        int r = s.length() - 1;

        char cl, cr;

        while (l < r) {
            cl = s.charAt(l);
            cr = s.charAt(r);

            if (!Character.isLetterOrDigit(cl)) {
                l++;
            } else if (!Character.isLetterOrDigit(cr)) {
                r--;
            } else {
                if (Character.toLowerCase(cl) != Character.toLowerCase(cr)) {
                    return false;
                }
                l++;
                r--;
            }
        }

        return true;
    }
}
