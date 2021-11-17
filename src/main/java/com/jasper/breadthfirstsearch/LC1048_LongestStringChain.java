package com.jasper.breadthfirstsearch;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LC1048_LongestStringChain {

    public int longestStrChain(String[] words) {
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
}
