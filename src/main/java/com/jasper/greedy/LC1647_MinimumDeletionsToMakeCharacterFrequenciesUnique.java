package com.jasper.greedy;

import java.util.HashSet;
import java.util.Set;

public class LC1647_MinimumDeletionsToMakeCharacterFrequenciesUnique {

    public int minDeletions(String s) {
        int cnt[] = new int[26];
        int res = 0;

        Set<Integer> used = new HashSet<>();

        for (int i = 0; i < s.length(); ++i) {
            cnt[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < 26; ++i) {
            while (cnt[i] > 0 && used.contains(cnt[i])) {
                cnt[i]--;
                res++;
            }

            used.add(cnt[i]);
        }

        return res;
    }
}
