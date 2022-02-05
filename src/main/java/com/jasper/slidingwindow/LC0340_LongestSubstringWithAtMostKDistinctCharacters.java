package com.jasper.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class LC0340_LongestSubstringWithAtMostKDistinctCharacters {

    // solution 1
    public int lengthOfLongestSubstringKDistinct1(String s, int k) {
        int res = 0;

        Map<Character, Integer> map = new HashMap<>();

        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);

            while (map.size() > k) {
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
    public int lengthOfLongestSubstringKDistinct2(String s, int k) {
        int[] map = new int[256];
        int res = 0;

        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            map[s.charAt(i)]++;
            while (!can(map, k)) {
                map[s.charAt(j)]--;
                j++;
            }

            if (res < (i - j + 1)) {
                res = i - j + 1;
            }
        }

        return res;
    }

    public boolean can(int[] map, int k) {
        int num = 0;
        for (int i = 0; i < map.length; i++) {
            if (map[i] > 0) {
                num++;
            }
            if (num > k)
                return false;
        }

        return true;
    }
}
