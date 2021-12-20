package com.jasper.string;

public class LC0065_ValidNumber {

    // solution 1 : new accept in leetcode
    public boolean isNumber1(String s) {
        s = s.toLowerCase().trim();
        boolean dotSeen = false; // to make sure that dot has been seen or not
        boolean eSeen = false; // to make sure if 'e' has been seen or not
        boolean isDigit = false; // once you encounter 'e' you have to have another digit after it otherwise not valid number

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                isDigit = true;
            } else if (s.charAt(i) == '.') {
                if (eSeen || dotSeen) return false; // a dot cannot occur after 'e' in valid num
                dotSeen = true;
            } else if (s.charAt(i) == 'e') {
                if (eSeen || !isDigit) return false; // if 'e' is in start, that is not a valid num
                eSeen = true;
                isDigit = false;
            } else if (s.charAt(i) == '+' || s.charAt(i) == '-') {
                if (i != 0 && s.charAt(i - 1) != 'e') return false;
            } else return false;
        }

        return isDigit;
    }

    // solution 2 : not accept in leetcode now
    public static boolean isNumber2(String s) {

        int i = 0;
        int length = s.length();
        while (i < length && s.charAt(i) == ' ') {
            i++;
        }

        if (i < length && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
            i++;
        }

        boolean isNumber = false;
        while (i < length && Character.isDigit(s.charAt(i))) {
            i++;
            isNumber = true;
        }

        if (i < length && s.charAt(i) == '.') {
            i++;
            while (i < length && Character.isDigit(s.charAt(i))) {
                i++;
                isNumber = true;
            }
        }

        if (isNumber && i < length && s.charAt(i) == 'e') {
            i++;
            isNumber = false;
            if (i < length && (s.charAt(i) == '+' || s.charAt(i) == '-'))
                i++;

            while (i < length && Character.isDigit(s.charAt(i))) {
                i++;
                isNumber = true;
            }
        }
        while (i < length && Character.isWhitespace(s.charAt(i)))
            i++;
        return isNumber && i == length;

    }

    public static void main(String[] args) {
        System.out.println(isNumber2("0.1"));
    }
}