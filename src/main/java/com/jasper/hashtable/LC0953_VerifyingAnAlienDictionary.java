package com.jasper.hashtable;

import java.util.HashMap;
import java.util.Map;

public class LC0953_VerifyingAnAlienDictionary {

    public boolean isAlienSorted(String[] words, String order) {
        Map<Character, Integer> orderMap = new HashMap<>();

        for (int i = 0; i < order.length(); i++) {
            orderMap.put(order.charAt(i), i);
        }

        for (int i = 0; i < words.length - 1; i++) {
            if (!isLess(words[i], words[i + 1], orderMap)) {
                return false;
            }
        }

        return true;
    }

    public boolean isLess(String str1, String str2, Map<Character, Integer> orderMap) {

        int index1 = 0;
        int index2 = 0;

        while (index1 < str1.length() && index2 < str2.length()) {
            char c1 = str1.charAt(index1);
            char c2 = str2.charAt(index2);
            if (c1 != c2) {
                if (orderMap.get(c1) > orderMap.get(c2)) {
                    return false;
                } else {
                    return true;
                }
            }
            index1++;
            index2++;
        }

        return str1.length() <= str2.length();
    }
}
