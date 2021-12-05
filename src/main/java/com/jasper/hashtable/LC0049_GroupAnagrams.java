package com.jasper.hashtable;

import java.util.*;

public class LC0049_GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {

        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }

        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            String keyStr = new String(ca);
            if (!map.containsKey(keyStr)) {
                map.put(keyStr, new ArrayList<>());
            }
            map.get(keyStr).add(s);
        }

        return new ArrayList<>(map.values());
    }
}
