package com.jasper.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class LC0395_LongestSubstringWithAtLeastKRepeatingCharacters {

    public int longestSubstring(String s, int k) {
        int res = 0;

        for (int unique = 1; unique <= 26; unique++) {
            Map<Character, Integer> map = new HashMap<>();
            int validCount = 0;
            int j = 0;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                map.put(c, map.getOrDefault(c, 0) + 1);

                if (map.get(c) == k) {
                    validCount++;
                }

                while (map.size() > unique) {
                    char leftChar = s.charAt(j);
                    if (map.get(leftChar) == k) {
                        validCount--;
                    }

                    map.put(leftChar, map.get(leftChar) - 1);
                    if (map.get(leftChar) == 0) {
                        map.remove(leftChar);
                    }

                    j++;
                }

                int count = map.size();
                if (count == unique && count == validCount) {
                    res = Math.max(res, i - j + 1);
                }
            }
        }

        return res;
    }
}
