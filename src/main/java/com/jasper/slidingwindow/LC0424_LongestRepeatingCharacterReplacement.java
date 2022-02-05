package com.jasper.slidingwindow;

public class LC0424_LongestRepeatingCharacterReplacement {



    // solution 2
    public int characterReplacement(String s, int k) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int[] h = new int[26];
        char[] ss = s.toCharArray();
        int result = 0;

        int j = 0;
        for (int i = 0; i < ss.length; i++) {
            h[ss[i] - 'A']++;
            while (!valid(h, k, i, j)) {
                h[ss[j] - 'A']--;
                j++;
            }
            result = Math.max(result, i - j + 1);
        }

        return result;
    }

    private boolean valid(int[] h, int k, int i, int j) {
        int max = 0;
        for (int t = 0; t < h.length; t++) {
            if (max < h[t]) {
                max = h[t];
            }
        }
        return i - j + 1 - max <= k;
    }
}
