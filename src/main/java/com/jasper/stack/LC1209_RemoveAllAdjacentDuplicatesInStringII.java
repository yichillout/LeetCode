package com.jasper.stack;

public class LC1209_RemoveAllAdjacentDuplicatesInStringII {

    // solution 1 : use array as stack
    public String removeDuplicates(String s, int k) {
        char[] ss = s.toCharArray();
        char[] stack = new char[ss.length];
        int[] count = new int[ss.length];


        int i = 0;
        int j = 0;

        while (j < ss.length) {
            stack[i] = ss[j];

            if (i > 0 && stack[i] == stack[i - 1]) {
                count[i] = count[i - 1] + 1;
            } else {
                count[i] = 1;
            }

            if (count[i] == k) {
                i -= k;
            }

            i++;
            j++;
        }

        return new String(stack, 0, i);
    }
}
