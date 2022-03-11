package com.jasper.depthfirstsearch;

import java.util.*;

public class LC0140_WordBreakII {

    // solution 1 : dfs
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<List<String>> result = new ArrayList<>();
        dfs(s, new ArrayList<>(), result, new HashSet<>(wordDict));
        List<String> formattedRes = new ArrayList<>();
        for (List<String> path : result) {
            formattedRes.add(String.join(" ", path));
        }

        return formattedRes;
    }

    public void dfs(String s, List<String> buffer, List<List<String>> result, Set<String> dict) {
        if (s.length() == 0) {
            result.add(new ArrayList<>(buffer));
            return;
        }

        for (int i = 1; i <= s.length(); i++) {
            String str = s.substring(0, i);
            if (dict.contains(str)) {
                buffer.add(str);
                dfs(s.substring(i), buffer, result, dict);
                buffer.remove(buffer.size() - 1);
            }
        }
    }

    // solution 2
    public List<String> wordBreak1(String s, List<String> wordDict) {
        Map<String, List<String>> memo = new HashMap<>();
        return helper(wordDict, s, memo);
    }

    private List<String> helper(List<String> wordDict, String s, Map<String, List<String>> memo) {
        if (memo.containsKey(s)) {
            return memo.get(s);
        }

        List<String> buffer = new ArrayList<>();

        if (wordDict.contains(s)) {
            buffer.add(s);
        }

        for (int i = 1; i < s.length(); i++) {
            String s1 = s.substring(0, i);
            String s2 = s.substring(i);
            if (wordDict.contains(s1)) {
                List<String> strList = helper(wordDict, s2, memo);
                for (String str : strList) {
                    buffer.add(s1 + " " + str);
                }
            }
        }

        memo.put(s, buffer);
        return buffer;
    }
}
