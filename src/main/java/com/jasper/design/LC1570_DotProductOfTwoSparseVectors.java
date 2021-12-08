package com.jasper.design;

import java.util.HashMap;
import java.util.Map;

class SparseVector {

    Map<Integer, Integer> map = new HashMap<>();

    SparseVector(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                map.put(i, nums[i]);
            }
        }
    }

    // Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {
        Map<Integer, Integer> smallMap = vec.map.size() <= map.size() ? vec.map : map;
        Map<Integer, Integer> bigMap = vec.map.size() > map.size() ? vec.map : map;

        int result = 0;
        for (Map.Entry<Integer, Integer> entry : smallMap.entrySet()) {
            if (bigMap.containsKey(entry.getKey())) {
                result += entry.getValue() * bigMap.get(entry.getKey());
            }
        }

        return result;
    }
}

public class LC1570_DotProductOfTwoSparseVectors {
}
