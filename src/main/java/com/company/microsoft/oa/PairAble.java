package com.company.microsoft.oa;

import java.util.HashMap;
import java.util.Map;

public class PairAble {

    public boolean isPairAble(int[] nums) {
        if (nums.length % 2 == 1) {
            return false;
        }

        Map<Integer, Integer> freqMap = new HashMap<>();

        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        for (int c : freqMap.keySet()) {
            if (freqMap.get(c) % 2 == 1) {
                return false;
            }
        }

        return true;
    }
}
