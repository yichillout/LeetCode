package com.jasper.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class LC0992_SubarraysWithKDifferentIntegers {

    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMostK(nums, k) - atMostK(nums, k - 1);
    }

    int atMostK(int[] nums, int k) {
        int j = 0;
        int res = 0;
        Map<Integer, Integer> count = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            if (count.getOrDefault(nums[i], 0) == 0) {
                k--;
            }
            count.put(nums[i], count.getOrDefault(nums[i], 0) + 1);

            while (k < 0) {
                count.put(nums[j], count.get(nums[j]) - 1);
                if (count.get(nums[j]) == 0) {
                    k++;
                }
                j++;
            }
            res += i - j + 1;
        }
        return res;
    }
}
