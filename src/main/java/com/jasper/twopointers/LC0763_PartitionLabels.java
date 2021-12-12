package com.jasper.twopointers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LC0763_PartitionLabels {

    // solution 1
    public List<Integer> partitionLabels1(String s) {
        if (s == null || s.length() == 0) {
            return null;
        }
        List<Integer> list = new ArrayList<>();
        int[] lastIndexMap = new int[26];  // record the last index of each char

        for (int i = 0; i < s.length(); i++) {
            lastIndexMap[s.charAt(i) - 'a'] = i;
        }

        // record the end index of the current sub string
        int last = 0;
        int index = 0;
        for (int i = 0; i < s.length(); i++) {
            last = Math.max(last, lastIndexMap[s.charAt(i) - 'a']);
            if (last == i) {
                list.add(last - index + 1);
                index = last + 1;
            }
        }

        return list;
    }

    // solution 2
    public List<Integer> partitionLabels2(String s) {

        int[] freqs = new int[26];

        Set<Character> hs = new HashSet<>();

        for (char c : s.toCharArray()) {
            freqs[c - 'a']++;
        }

        List<Integer> result = new ArrayList<>();

        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            freqs[s.charAt(i) - 'a']--;
            hs.add(s.charAt(i));
            if (isValid(freqs, hs)) {
                result.add(i - j + 1);
                j = i + 1;
            }
        }

        return result;
    }

    public boolean isValid(int[] freqs, Set<Character> hs) {
        for (char c : hs) {
            if (freqs[c - 'a'] > 0) {
                return false;
            }
        }
        return true;
    }
}
