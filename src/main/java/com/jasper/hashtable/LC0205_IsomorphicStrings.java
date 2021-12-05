package com.jasper.hashtable;

import java.util.HashMap;
import java.util.Map;

public class LC0205_IsomorphicStrings {

    public boolean isIsomorphic(String s, String t) {
        if (s == null || s.length() <= 1) {
            return true;
        }

        HashMap<Character, Character> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i);
            char b = t.charAt(i);
            if (map.containsKey(a)) {
                if (map.get(a) == b) {
                    continue;
                } else {
                    return false;
                }
            } else {
                if (!map.containsValue(b)) {
                    map.put(a, b);
                } else {
                    return false;
                }
            }
        }

        return true;
    }
}