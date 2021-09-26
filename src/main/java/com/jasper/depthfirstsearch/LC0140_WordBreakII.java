package com.jasper.depthfirstsearch;

import java.util.*;

public class LC0140_WordBreakII {

    // solution 1
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


    // solution 2 : dfs
    public List<String> wordBreak2(String s, List<String> wordDict) {

        Set<String> dict = new HashSet<>(wordDict);
        List<String> buffer = new ArrayList<>();
        List<List<String>> result = new ArrayList<>();

        for (int i = 1; i <= s.length(); i++) {
            String str = s.substring(0, i);
            if (dict.contains(str)) {
                buffer.add(str);
                helper(s.substring(i), buffer, dict, result);
                buffer.remove(buffer.size() - 1);
            }
        }

        List<String> formattedResult = new ArrayList<>();
        for (List<String> r : result) {
            formattedResult.add(String.join(" ", r));
        }
        return formattedResult;
    }

    public void helper(String s, List<String> buffer, Set<String> dict, List<List<String>> result) {
        if (s.equals("")) {
            result.add(new ArrayList<String>(buffer));
        }

        for (int i = 1; i <= s.length(); i++) {
            String str = s.substring(0, i);
            if (dict.contains(str)) {
                buffer.add(str);
                helper(s.substring(i), buffer, dict, result);
                buffer.remove(buffer.size() - 1);
            }
        }
    }
}
