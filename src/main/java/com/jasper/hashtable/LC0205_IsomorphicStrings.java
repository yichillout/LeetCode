package com.jasper.hashtable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LC0205_IsomorphicStrings {

    // solution 1 : using array
    public boolean isIsomorphic(String s, String t) {

        int[] mapS2T = new int[256];
        int[] mapT2S = new int[256];

        for (int i = 0; i < mapS2T.length; i++) {
            mapS2T[i] = -1;
            mapT2S[i] = -1;
        }

        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);

            if (mapS2T[c1] == -1 && mapT2S[c2] == -1) {
                mapS2T[c1] = c2;
                mapT2S[c2] = c1;
            } else if (!(mapS2T[c1] == c2 && mapT2S[c2] == c1)) {
                return false;
            }
        }

        return true;
    }

    // solution 2 : using map
    public boolean isIsomorphic2(String s, String t) {
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
