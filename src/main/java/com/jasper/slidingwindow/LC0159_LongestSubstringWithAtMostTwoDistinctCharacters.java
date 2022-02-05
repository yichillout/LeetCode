package com.jasper.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class LC0159_LongestSubstringWithAtMostTwoDistinctCharacters {

    // solution 1
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int res = 0;

        Map<Character, Integer> map = new HashMap<>();

        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);

            while (map.size() > 2) {
                char left = s.charAt(j);
                map.put(left, map.get(left) - 1);
                if (map.get(left) == 0) {
                    map.remove(left);
                }
                j++;
            }

            res = Math.max(res, i - j + 1);
        }

        return res;
    }

    // solution 2
    public int lengthOfLongestSubstringTwoDistinct2(String s) {
        int j = 0;
        int[] counts = new int[256];
        int res = 0;

        for (int i = 0; i < s.length(); i++) {
            counts[s.charAt(i)]++;
            while (!can(counts)) {
                counts[s.charAt(j)]--;
                j++;
            }

            if (res < (i - j + 1)) {
                res = i - j + 1;
            }
        }

        return res;
    }

    public boolean can(int[] map) {
        int num = 0;
        for (int i = 0; i < map.length; i++) {
            if (map[i] > 0) {
                num++;
            }
            if (num > 2)
                return false;
        }

        return true;
    }

}
