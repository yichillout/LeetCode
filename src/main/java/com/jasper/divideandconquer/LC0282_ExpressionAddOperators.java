package com.jasper.divideandconquer;

import java.util.ArrayList;
import java.util.List;

public class LC0282_ExpressionAddOperators {

    public List<String> addOperators(String num, int target) {
        List<String> result = new ArrayList<>();
        helper(result, "", num, target, 0, 0, 0);
        return result;
    }

    public void helper(List<String> result, String path, String num, int target, int index, long curValue, long preValue) {

        if (index == num.length()) {
            if (curValue == target) {
                result.add(path);
            }
            return;
        }

        for (int i = index; i < num.length(); i++) {
            if (i != index && num.charAt(index) == '0') {
                break;
            }

            long value = Long.parseLong(num.substring(index, i + 1));

            if (index == 0) {
                helper(result, path + value, num, target, i + 1, value, value);
            } else {
                helper(result, path + "+" + value, num, target, i + 1, curValue + value, value);
                helper(result, path + "-" + value, num, target, i + 1, curValue - value, -value);
                helper(result, path + "*" + value, num, target, i + 1, curValue - preValue + preValue * value, preValue * value);
            }
        }
    }
}
