package com.jasper.backtracking;

import java.util.*;

public class LC1048_LongestStringChain {

    // solution 1 : back tracking
    public int longestStrChain1(String[] words) {
        Set<String> set = new HashSet<>();
        Map<String, Integer> map = new HashMap<>();

        for (String word : words) {
            set.add(word);
        }

        int ans = 1;

        for (String word : words) {
            ans = Math.max(ans, backtrack(set, map, word));
        }

        return ans;
    }

    private int backtrack(Set<String> set, Map<String, Integer> map, String str) {
        Integer pathLen = map.get(str);
        int res = 1;
        if (pathLen != null) {
            return pathLen;
        }

        String sb = null;

        for (int i = 0; i < str.length(); i++) {
            sb = str.substring(0, i) + str.substring(i + 1);
            if (set.contains(sb)) {
                res = Math.max(1 + backtrack(set, map, sb), res);
            }
        }

        map.put(str, res);

        return res;
    }

    // solution 2 : DP
    public int longestStrChain(String[] words) {
        Map<String, Integer> dp = new HashMap<>();

        Arrays.sort(words, (a, b) -> a.length() - b.length());

        int res = 0;

        for (String word : words) {
            int best = 0;
            for (int i = 0; i < word.length(); ++i) {
                String prev = word.substring(0, i) + word.substring(i + 1);
                best = Math.max(best, dp.getOrDefault(prev, 0) + 1);
            }
            dp.put(word, best);
            res = Math.max(res, best);
        }

        return res;
    }
}
