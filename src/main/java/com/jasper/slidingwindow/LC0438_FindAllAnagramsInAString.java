package com.jasper.slidingwindow;

import java.util.ArrayList;
import java.util.List;

public class LC0438_FindAllAnagramsInAString {

    // solution 1 : sliding window
    public List<Integer> findAnagrams1(String s, String p) {
        List<Integer> list = new ArrayList<>();

        if (s == null || s.length() == 0 || p == null || p.length() == 0)
            return list;

        int[] hash = new int[256];

        for (char c : p.toCharArray()) {
            hash[c]++;
        }

        int count = p.length();

        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            if (hash[s.charAt(i)] > 0) {
                count--;
            }

            hash[s.charAt(i)]--;

            if (count == 0) {
                list.add(j);
            }

            if (i - j + 1 == p.length()) {
                if (hash[s.charAt(j)] >= 0) {
                    count++;
                }

                hash[s.charAt(j)]++;
                j++;
            }

        }
        return list;
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
