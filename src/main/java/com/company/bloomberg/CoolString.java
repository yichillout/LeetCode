package com.company.bloomberg;

import java.util.HashMap;
import java.util.Map;

public class CoolString {

    private static boolean getCoolString(String s) {
        int[] occurrence = new int[128];
        Map<Integer, Integer> map = new HashMap<>();
        int[] common = new int[2];
        int[] special = new int[2];

        // step 1: get the occurence of every character, store in int[128]
        for (int i = 0; i < s.length(); i++) {
            occurrence[s.charAt(i)]++;
        }

        //step 2: find out how many occurrence of character in the int[128], store in HashMap
        for (int i = 0; i < 128; i++) {
            if (occurrence[i] != 0) {
                map.put(occurrence[i], map.getOrDefault(occurrence[i], 0) + 1);
            }
        }

        //step 3: get the result, if only one element in the map, return true;
        if (map.size() == 1) {
            return true;
        }

        //step 4: if the HashMap contains more than 2 elements, return false;
        else if (map.size() > 2) {
            return false;
        }

        //step 5: analysis the hashmap that contains two element
        else if (map.containsValue(1)) {
            for (int i : map.keySet()) {
                if (map.get(i) == 1) {
                    special[0] = i;
                    special[1] = 1;
                } else {
                    common[0] = i;
                    common[1] = map.get(i);
                }
            }

            if (special[0] - common[0] == 1) {
                return true;
            }

            if (special[0] == 1) {
                return true;
            }
        }
        return false;
    }
}
