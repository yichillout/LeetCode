package com.jasper.math;

public class LC0670_MaximumSwap {

    public int maximumSwap(int num) {

        char[] digits = Integer.toString(num).toCharArray();

        for (int i = 0; i < digits.length - 1; i++) {
            int max = Integer.MIN_VALUE;
            int tmpIndex = -1;
            for (int j = i + 1; j < digits.length; j++) {
                if (max <= digits[j]) {
                    max = digits[j];
                    tmpIndex = j;

                }
            }

            if (digits[i] < max) {
                swap(digits, i, tmpIndex);
                break;
            }
        }

        return num;
    }

    public void swap(char[] digits, int x, int y) {
        char tmp = digits[x];
        digits[x] = digits[y];
        digits[y] = tmp;
    }

}
