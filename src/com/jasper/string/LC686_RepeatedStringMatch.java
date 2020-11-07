package com.jasper.string;

public class LC686_RepeatedStringMatch {

    public int repeatedStringMatch(String a, String b) {

        int count = 0;
        StringBuilder sb = new StringBuilder();

        while (sb.length() < b.length()) {
            sb.append(a);
            count++;
        }

        if (sb.toString().contains(b)) {
            return count;
        }

        if (sb.append(a).toString().contains(b)) {
            return ++count;
        }

        return -1;
    }
}
