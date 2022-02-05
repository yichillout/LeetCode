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
     * <p>
     * 0   A : count=3 -> [A=0,B=2,C=1]                      -> j=0
     * 1   D : count=3 -> [A=0,B=2,C=1,D=-1]                 -> j=0
     * 2   O : count=3 -> [A=0,B=2,C=1,D=-1,0=-1]            -> j=0
     * 3   B : count=2 -> [A=0,B=1,C=1,D=-1,0=-1]            -> j=0
     * 4   E : count=2 -> [A=0,B=1,C=1,D=-1,0=-1,E=-1]       -> j=0
     * 5   C : count=1 -> [A=0,B=1,C=0,D=-1,0=-1,E=-1]       -> j=0
     * 6   E : count=1 -> [A=0,B=1,C=0,D=-1,0=-1,E=-2]       -> j=0
     * 7   B : count=0 -> [A=0,B=0,C=0,D=-1,0=-1,E=-2]       -> j=0  minStart=0, minLen=7-0+1=7, res=ADOBECEB -> count=1 -> [A=1,B=0,C=0,D=-1,0=-1,E=-2] -> j=1 // just keep count > 0
     * 8   A : count=0 -> [A=0,B=0,C=0,D= 0,O= 0,E=-2]       -> j=3  minStart=3, minLen=8-3+1=6, res=BECEBA   -> count=1 -> [A=0,B=1,C=0,D= 0,O= 0,E=-2] -> j=4 // just keep count > 0
     * 9   N : count=1 -> [A=0,B=1,C=0,D= 0,O= 0,E=-2,N=-1]  -> j=4
     * 10  C : count=1 -> [A=0,B=1,C=-1,D= 0,O= 0,E=-2,N=-1] -> j=4
     */
    public String minWindow1(String s, String t) {

        int[] freqs = new int[256];

        int count = t.length();
        int minLen = Integer.MAX_VALUE;

        String res = "";

        for (char c : t.toCharArray()) {
            freqs[c]++;
        }

        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (freqs[c] > 0) {
                count--;
            }
            freqs[c]--;

            while (count == 0) {
                if (i - j + 1 < minLen) {
                    minLen = i - j + 1;
                    res = s.substring(j, j + minLen);
                }

                freqs[s.charAt(j)]++;
                if (freqs[s.charAt(j)] > 0) {
                    count++;
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