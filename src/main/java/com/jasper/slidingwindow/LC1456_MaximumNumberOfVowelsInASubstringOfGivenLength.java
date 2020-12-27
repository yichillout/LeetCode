package com.jasper.slidingwindow;

public class LC1456_MaximumNumberOfVowelsInASubstringOfGivenLength {

    public int maxVowels(String s, int k) {
        char[] ss = s.toCharArray();
        int result = 0;
        int count = 0;

        for (int i = 0; i < k; i++) {
            if (isVowel(ss[i])) {
                count++;
            }
        }

        if (count > result) {
            result = count;
        }

        if (result == k) {
            return result;
        }

        for (int i = k; i < ss.length; i++) {
            if (isVowel(ss[i])) {
                count++;
            }
            if (isVowel(ss[i - k])) {
                count--;
            }
            if (count > result) {
                result = count;
            }
        }

        return result;
    }

    private boolean isVowel(char c) {
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
            return true;
        }
        return false;
    }
}
