package com.jasper.matrix;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC1424_DiagonalTraverseII {

    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int max = Integer.MIN_VALUE;
        int count = 0;

        for (int i = nums.size() - 1; i >= 0; i--) {
            List<Integer> list = nums.get(i);
            for (int j = list.size() - 1; j >= 0; j--) {
                if (!map.containsKey(i + j)) {
                    map.put(i + j, new ArrayList<>());
                }

                map.get(i + j).add(list.get(j));
                count++;

                if (i + j > max) {
                    max = i + j;
                }
            }
        }

        int[] result = new int[count];
        int index = 0;
        for (int i = 0; i <= max; i++) {
            List<Integer> list = map.get(i);
            for (int j = 0; j < list.size(); j++) {
                result[index++] = list.get(j);
            }
        }

        return result;
    }
}
