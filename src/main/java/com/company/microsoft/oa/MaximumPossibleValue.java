package com.company.microsoft.oa;


/**
 * Maximum possible value by inserting '5'
 * examples:
 * input: 1234 -> output: 51234
 * input: 7643 -> output 76543
 * input: 0 -> output 50
 * input: -661 -> output -5661
 */
public class MaximumPossibleValue {

    public static String maxValue(String n, int x) {
        boolean isNegative = false;

        if ('-' == n.charAt(0)) {
            isNegative = true;
            n = n.substring(1);
        }

        for (int i = 0; i < n.length(); i++) {
            int num = n.charAt(i) - '0';
            if ((!isNegative && x > num) || (isNegative && x < num)) {
                return (!isNegative ? "" : "-") + n.substring(0, i) + x + n.substring(i);
            }
        }

        return (!isNegative ? "" : "-") + n + x;
    }

    public static void main(String[] args) {
        System.out.println(maxValue("7643", 5));
        System.out.println(maxValue("-661", 5));
        System.out.println(maxValue("0", 5));
    }
}
