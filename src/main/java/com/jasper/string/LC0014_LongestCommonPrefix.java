package com.jasper.string;

public class LC0014_LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            int count = 1;
            for (int j = 1; j < strs.length; j++) {
                if (i < strs[j].length() && c == strs[j].charAt(i)) {
                    count++;
                } else {
                    break;
                }
            }

            if (count == strs.length) {
                sb.append(c);
            } else {
                break;
            }
        }

        return sb.toString();
    }
}
