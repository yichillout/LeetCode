package com.jasper.hashtable;

public class LC0791_CustomSortString {

    public String customSortString(String order, String s) {

        char[] orders = order.toCharArray();

        int[] freqs = new int[26];

        for (char c : s.toCharArray()) {
            freqs[c - 'a']++;
        }

        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < orders.length; i++) {
            int freq = freqs[orders[i] - 'a'];
            int count = 0;
            while (count < freq) {
                builder.append(orders[i]);
                count++;
            }
            freqs[orders[i] - 'a'] = 0;
        }

        for (int i = 0; i < freqs.length; i++) {
            if (freqs[i] == 0) {
                continue;
            }

            int count = 0;
            while (count < freqs[i]) {
                builder.append((char) (i + 'a'));
                count++;
            }
        }

        return builder.toString();
    }
}
