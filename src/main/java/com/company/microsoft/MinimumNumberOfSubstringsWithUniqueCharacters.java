package com.company.microsoft;

import java.util.HashSet;
import java.util.Set;

/**
 * Split the given string into minimum number of substrings with unique characters such that the concatenation of all the substrings will result in the given string.
 * <p>
 * Examples:
 * "dddd" --> ["d", "d", "d", "d"] --> answer should be 4.
 * "abab" --> ["ab", "ab"] --> answer should be 2.
 */

public class MinimumNumberOfSubstringsWithUniqueCharacters {


    // solution 1 : dfs
    private static int res;

    public static int getMinimum1(String s) {
        res = Integer.MAX_VALUE;
        backTrack(s, "", 0, 0);
        return res;
    }

    private static void backTrack(String s, String cur, int ind, int splits) {
        if (cur.length() == s.length()) {
            res = Math.min(res, splits);
            return;
        }
        for (int i = ind; i < s.length(); i++) {
            String str = s.substring(ind, i + 1);
            if (isSafe(str)) {
                backTrack(s, cur + str, i + 1, splits + 1);
            }
        }
    }

    private static boolean isSafe(String cur) {
        Set<Character> hs = new HashSet<>();
        for (int i = 0; i < cur.length(); i++) {
            if (hs.contains(cur.charAt(i)))
                return false;
            hs.add(cur.charAt(i));
        }
        return true;
    }

    // solution 2
    private static int splitSring2(String S) {
        if (S == null || S.length() == 0) {
            return 0;
        }

        Set<Character> set = new HashSet<>();

        int count = 1;
        for (char c : S.toCharArray()) {
            if (set.contains(c)) {
                set.clear();
                set.add(c);
                count++;
            } else {
                set.add(c);
            }
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(getMinimum1("dddd"));
        System.out.println(getMinimum1("ddcd"));

        System.out.println(splitSring2("dddd"));
        System.out.println(splitSring2("ddcd"));
    }
}
