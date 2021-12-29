package com.jasper.twopointers;

public class LC1209_RemoveAllAdjacentDuplicatesInStringII {

    public String removeDuplicates(String s, int k) {
        int j = 0;
        int n = s.length();
        int[] count = new int[n];

        char[] stack = s.toCharArray();

        for (int i = 0; i < n; ++i) {
            stack[j] = stack[i];
            count[j] = j > 0 && stack[j - 1] == stack[i] ? count[j - 1] + 1 : 1;
            if (count[j] == k) {
                j -= k;
            }
            j++;
        }
        return new String(stack, 0, j);
    }
}
