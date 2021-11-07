package com.jasper.string;

public class LC0161_OneEditDistance {

    // example : s = "";  t = "" -> false

    public boolean isOneEditDistance(String s, String t) {

        int m = s.length();
        int n = t.length();

        if (Math.abs(m - n) > 1) {
            return false;
        }

        if (m == n) {
            for (int i = 0; i < n; i++) {
                if (s.charAt(i) != t.charAt(i)) {
                    return s.substring(i + 1).equals(t.substring(i + 1));
                }
            }
            return false;
        } else if (m > n) {
            return isRemove(s, t);
        } else {
            return isRemove(t, s);
        }
    }

    public boolean isRemove(String longStr, String shortStr) {
        int i = 0;
        int j = 0;

        while (i < longStr.length() && j < shortStr.length()) {
            if (longStr.charAt(i) != shortStr.charAt(j)) {
                return longStr.substring(i + 1).equals(shortStr.substring(j));
            }
            i++;
            j++;
        }

        // that means the longStr need to remove the last character
        return true;
    }
}
