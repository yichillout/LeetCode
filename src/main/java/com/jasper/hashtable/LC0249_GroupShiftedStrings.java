package com.jasper.hashtable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC0249_GroupShiftedStrings {

    public List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> hm = new HashMap<>();

        for (String str : strings) {
            StringBuilder builder = new StringBuilder();
            char[] ss = str.toCharArray();
            for (int i = 1; i < ss.length; i++) {
                int c = ss[i] - ss[i - 1];
                if (c < 0) {
                    c += 26;
                }
                builder.append(c + ",");
            }

            if (!hm.containsKey(builder.toString())) {
                hm.put(builder.toString(), new ArrayList<>());
            }

            hm.get(builder.toString()).add(str);
        }


        return new ArrayList<>(hm.values());
    }
}
