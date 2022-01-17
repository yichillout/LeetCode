package com.jasper.slidingwindow;

import java.util.HashMap;

public class LC0076_MinimumWindowSubstring {

    // solution 1

    /**
     * t="ABCB"
     * [A=1,B=2,C=1]
     * count=4
     * "ADOBECEBANC"
     * output="BECEBA"
     *
     * 0   A : count=3 -> [A=0,B=2,C=1]  -> j=0
     * 1   D : count=3 -> [A=0,B=2,C=1]  -> j=0
     * 2   O : count=3 -> [A=0,B=2,C=1]  -> j=0
     * 3   B : count=2 -> [A=0,B=1,C=1]  -> j=0
     * 4   E : count=2 -> [A=0,B=1,C=1]  -> j=0
     * 5   C : count=1 -> [A=0,B=1,C=0]  -> j=0
     * 6   E : count=1 -> [A=0,B=1,C=0]  -> j=0
     * 7   B : count=0 -> [A=0,B=0,C=0]  -> j=0  minStart=0, minLen=7-0+1=7, res=ADOBECEB -> count=1 -> [A=1,B=0,C=0] -> j=1
     * 8   A : count=0 -> [A=0,B=0,C=0]  -> j=3  minStart=3, minLen=8-3+1=6, res=BECEBA   -> count=1 -> [A=0,B=1,C=0] -> j=4
     * 9   N : count=1 -> [A=0,B=1,C=0]  -> j=4
     * 10  C : count=1 -> [A=0,B=1,C=-1] -> j=4
     */
    public String minWindow1(String s, String t) {
        int[] map = new int[128];

        for (char c : t.toCharArray()) {
            map[c]++;
        }

        int j = 0;
        String res = "";
        int minLen = Integer.MAX_VALUE;
        int counter = t.length();

        for (int i = 0; i < s.length(); i++) {
            final char c = s.charAt(i);
            if (map[c] > 0) {
                counter--;
            }
            map[c]--;

            while (counter == 0) {
                if (minLen > i - j + 1) {
                    minLen = i - j + 1;
                    res = s.substring(j, j + minLen);
                }

                char c2 = s.charAt(j);
                map[c2]++;
                if (map[c2] > 0) {
                    counter++;
                }
                j++;
            }
        }

        return res;
    }

    // solution 2
    public static String minWindow2(String s, String t) {

        int[] count = new int[256];
        int minLen = Integer.MAX_VALUE;
        String str = "";

        for (int i = 0; i < t.length(); i++) {
            count[t.charAt(i)]++;
        }

        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i)]--;
            while (can(count)) {
                if (i - j + 1 < minLen) {
                    str = s.substring(j, i + 1);
                    minLen = i - j + 1;
                }
                count[s.charAt(j)]++;
                j++;
            }
        }

        return str;
    }

    private static boolean can(int[] count) {
        for (int i = 0; i < count.length; i++) {
            if (count[i] > 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(minWindow2("ADOBECODEBANC", "ABC"));
    }
}