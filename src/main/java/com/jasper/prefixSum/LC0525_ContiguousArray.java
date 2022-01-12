package com.jasper.prefixSum;

import java.util.HashMap;
import java.util.Map;

public class LC0525_ContiguousArray {

    // 反转0位-1，然后用two sum的方法去找了和为0的subarray
    public int findMaxLength(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                nums[i] = -1;
            }
        }

        int sum = 0;
        int res = 0;

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum)) {
                res = Math.max(res, i - map.get(sum));
            } else {
                map.put(sum, i);
            }
        }

        return res;
    }
}
