package com.jasper.greedy;

public class LC1881_MaximumValueAfterInsertion {

    public String maxValue(String n, int x) {
        boolean isPositive = true;

        if ('-' == n.charAt(0)) {
            isPositive = false;
            n = n.substring(1);
        }

        for (int i = 0; i < n.length(); i++) {
            int num = n.charAt(i) - '0';
            if ((isPositive && x > num) || (!isPositive && x < num)) {
                return (isPositive ? "" : "-") + n.substring(0, i) + x + n.substring(i);
            }
        }

        return (isPositive ? "" : "-") + n + x;
    }
}
