package com.jasper.depthfirstsearch;

import java.util.*;

public class LC0017_LetterCombinationsOfAPhoneNumber {
    public List<String> letterCombinations(String digits) {

        List<String> result = new ArrayList<>();
        Map<Character, String> map = new HashMap<>();

        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        if (digits == null || digits.length() == 0)
            return result;

        StringBuilder builder = new StringBuilder();
        letterCombinationsHelper(digits, builder, result, map, 0);
        return result;
    }

    public void letterCombinationsHelper(String digits, StringBuilder builder, List<String> result,
                                         Map<Character, String> map, int index) {

        if (index == digits.length()) {
            result.add(builder.toString());
            return;
        }

        String str = map.get(digits.charAt(index));

        for (int i = 0; i < str.length(); i++) {
            builder.append(str.charAt(i));
            letterCombinationsHelper(digits, builder, result, map, index + 1);
            builder.deleteCharAt(builder.length() - 1);
        }

    }
}
