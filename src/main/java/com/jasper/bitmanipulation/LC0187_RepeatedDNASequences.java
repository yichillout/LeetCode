package com.jasper.bitmanipulation;

import java.util.*;

public class LC0187_RepeatedDNASequences {

    public List<String> findRepeatedDnaSequences1(String s) {
        List<String> res = new ArrayList<>();
        Set<String> hs = new HashSet<>();

        if (s == null || s.length() <= 10) {
            return res;
        }

        Set<String> set = new HashSet<>();

        for (int i = 0; i <= s.length() - 10; i++) {
            String sub = s.substring(i, i + 10);
            if (set.contains(sub)) {
                hs.add(sub);
            } else {
                set.add(sub);
            }
        }

        res.addAll(hs);

        return res;
    }

    public static List<String> findRepeatedDnaSequences2(String s) {

        List<String> ans = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        int key = 0;
        for (int i = 0; i < s.length(); i++) {
            key = ((key << 3) | (s.charAt(i) & 0x7)) & 0x3fffffff;
            System.out.println(Integer.toBinaryString(key));
            if (i < 9)
                continue;
            if (map.get(key) == null) {
                map.put(key, 1);
            } else if (map.get(key) == 1) {
                ans.add(s.substring(i - 9, i + 1));
                map.put(key, 2);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        ArrayList array = (ArrayList) findRepeatedDnaSequences2("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT");
    }

}
