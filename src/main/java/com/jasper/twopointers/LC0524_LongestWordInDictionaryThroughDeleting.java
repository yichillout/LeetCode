package com.jasper.twopointers;

import java.util.Collections;
import java.util.List;

public class LC0524_LongestWordInDictionaryThroughDeleting {

    public String findLongestWord(String s, List<String> dictionary) {
        String maxStr = "";
        Collections.sort(dictionary);

        for (String str : dictionary) {
            if (str.length() > s.length()) {
                continue;
            }

            if (isSubString(str, s) && str.length() > maxStr.length()) {
                maxStr = str;
            }
        }

        return maxStr;
    }

    public boolean isSubString(String str, String longStr) {
        int i = 0;
        int j = 0;
        while (i < longStr.length() && j < str.length()) {
            if (longStr.charAt(i) == str.charAt(j)) {
                j++;
            }
            i++;
        }
        return j == str.length();
    }
}
