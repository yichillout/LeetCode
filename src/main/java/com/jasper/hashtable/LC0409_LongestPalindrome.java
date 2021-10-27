package com.jasper.hashtable;

public class LC0409_LongestPalindrome {
    // ASCII table a:97 A:65

    // n is the length of string     n - oddCount :  means that all the odd number should become the even number
    // n - oddCount + 1 : means that it will keep the longest odd number
    public int longestPalindrome(String s) {
        char[] ss = s.toCharArray();
        int[] freqs = new int[256];

        for (char c : ss) {
            freqs[c]++;
        }

        int oddFreqCount = 0;
        for (int i = 0; i < freqs.length; i++) {
            if (freqs[i] % 2 == 1) {
                oddFreqCount++;
            }
        }

        return oddFreqCount == 0 ? ss.length : ss.length - oddFreqCount + 1;
    }
}
