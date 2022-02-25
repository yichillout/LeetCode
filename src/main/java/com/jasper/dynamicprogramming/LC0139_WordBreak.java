package com.jasper.dynamicprogramming;

import java.util.*;

public class LC0139_WordBreak {

    // 0 1 2 3 4 5 6 7 8
    // t       t       t --- i    	
    //   l e e t c o d e
    //   0 1 2 3 4 5 6 7 --- j

    public static boolean wordBreak(String s, List<String> wordDict) {

        boolean[] dp = new boolean[s.length() + 1];

        Set<String> dict = new HashSet<>();
        for (String word : wordDict) {
            dict.add(word);
        }

        dp[0] = true;

        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                String str = s.substring(j, i);
                if (dp[j] && dict.contains(str)) {
                    dp[i] = true;
                }
            }
        }

        return dp[dp.length - 1];
    }

    public static void main(String[] args) {
        String s = "leetcode";
        List<String> dict = new ArrayList<String>();
        dict.add("leet");
        dict.add("code");
        System.out.println(wordBreak(s, dict));
    }
}
