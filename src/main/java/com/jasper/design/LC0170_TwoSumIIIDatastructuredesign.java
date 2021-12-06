package com.jasper.design;

import java.util.*;

class TwoSum {

    Map<Integer, Integer> map;

    public TwoSum() {
        map = new HashMap<>();
    }

    public void add(int number) {
        if (map.containsKey(number)) {
            map.put(number, map.get(number) + 1);
        } else {
            map.put(number, 1);
        }
    }

    public boolean find(int value) {
        for (int key : map.keySet()) {
            int another = value - key;
            if (another == key && map.get(key) > 1) {
                return true;
            } else if (another != key && map.containsKey(another)) {
                return true;
            }
        }
        return false;
    }
}

public class LC0170_TwoSumIIIDatastructuredesign {

}
