package com.jasper.slidingwindow;

public class LC0159_LongestSubstringWithAtMostTwoDistinctCharacters {

    public int lengthOfLongestSubstringTwoDistinct(String s) {

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
