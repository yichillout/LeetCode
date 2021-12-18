package com.jasper.binarysearch;

public class LC0744_FindSmallestLetterGreaterThanTarget {

    public char nextGreatestLetter(char[] letters, char target) {
        int l = 0;
        int r = letters.length - 1;

        while (l + 1 < r) {
            int mid = l + (r - l) / 2;

            if (!isLessOrEqual(letters[mid], target)) {
                r = mid;
            } else {
                l = mid;
            }
        }

        if (letters[l] > target) {
            return letters[l];
        }

        if (letters[r] > target) {
            return letters[r];
        }

        return letters[0];
    }

    public boolean isLessOrEqual(char c1, char c2) {
        return c1 <= c2 ? true : false;
    }
}
