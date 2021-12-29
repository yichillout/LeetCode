package com.jasper.twopointers;

public class LC1047_RemoveAllAdjacentDuplicatesInString {

    public String removeDuplicates(String s) {
        int j = 0;

        char[] ss = s.toCharArray();

        for (int i = 0; i < ss.length; i++) {
            ss[j] = ss[i];
            if (j > 0 && ss[j] == ss[j - 1]) {
                j -= 2;
            }
            j++;
        }

        return new String(ss, 0, j);
    }
}
