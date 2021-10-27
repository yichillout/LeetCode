package com.jasper.slidingwindow;

import java.util.ArrayList;
import java.util.List;

public class LC0438_FindAllAnagramsInAString {

    // solution 1 : sliding window TODO
    public List<Integer> findAnagrams1(String s, String p) {
            int[] freq = new int[256];

            for (int i = 0; i < p.length(); i++) {
                freq[p.charAt(i)]++;
            }

            List<Integer> result = new ArrayList<>();
            int diff = p.length();

            for (int i = 0, j = 0; i < s.length(); i++) {
                if (freq[s.charAt(i)] > 0) {
                    freq[s.charAt(i)]--;
                    diff--;
                }

                while (diff == 0) {
                    if (i - j + 1 == p.length()) { // Here is the key!
                        result.add(j);
                    }


                    if (++freq[s.charAt(j++)] > 0) {
                        diff++;
                    }
                }
            }
            return result;
    }

    // solution 2
    public List<Integer> findAnagrams2(String s, String p) {

        List<Integer> result = new ArrayList<>();

        if (s == null || p == null || s.length() < p.length()) {
            return result;
        }

        int N = p.length();
        int[] pCount = new int[26];
        for (char c : p.toCharArray()) {
            pCount[c - 'a']++;
        }

        for (int i = 0; i < s.length() - N + 1; i++) {
            String str = s.substring(i, i + N);
            int[] sCount = new int[26];
            for (char c : str.toCharArray()) {
                sCount[c - 'a']++;
            }
            if (isValid(sCount, pCount)) {
                result.add(i);
            }
        }

        return result;
    }

    public boolean isValid(int[] count1, int[] count2) {
        for (int i = 0; i < count1.length; i++) {
            if (count1[i] != count2[i]) {
                return false;
            }
        }

        return true;
    }
}
