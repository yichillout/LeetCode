package com.jasper.design;

import java.util.*;

class TwoSum {

    Map<Integer, Integer> countMap;

    public TwoSum() {
        countMap = new HashMap<>();
    }

    public void add(int number) {
        if (countMap.containsKey(number)) {
            countMap.put(number, countMap.get(number) + 1);
        } else {
            countMap.put(number, 1);
        }
    }

    public boolean find(int value) {
        for (int key : countMap.keySet()) {
            int another = value - key;
            if (another == key && countMap.get(key) > 1) {
                return true;
            } else if (another != key && countMap.containsKey(another)) {
                return true;
            }
        }
        return false;
    }
}

public class LC0170_TwoSumIIIDatastructuredesign {

}
