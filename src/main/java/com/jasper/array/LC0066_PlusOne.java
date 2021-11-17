package com.jasper.array;

import java.util.ArrayList;
import java.util.List;

public class LC0066_PlusOne {

    public int[] plusOne(int[] digits) {

        List<Integer> result = new ArrayList<>();
        int carry = 1;

        for (int i = digits.length - 1; i >= 0; i--) {
            int num = carry + digits[i];
            result.add(num % 10);
            carry = num / 10;
        }

        if (carry != 0) {
            result.add(carry);
        }

        int[] res = new int[result.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = result.get(res.length - 1 - i);
        }

        return res;
    }
}
