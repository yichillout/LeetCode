package com.jasper.hashtable;

import java.util.HashMap;
import java.util.Map;

public class LC0325_MaximumSizeSubarraySumEqualsK {

    public int maxSubArrayLen(int[] nums, int k) {
        int sum = 0;
        int maxLen = 0;
        Map<Integer, Integer> sumToIndexMap = new HashMap<Integer, Integer>();
        sumToIndexMap.put(0, -1); // without this, we need to use the following comment code
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

//            if (sum == k) {
//                maxLen = i + 1;
//            } else if (sumToIndexMap.containsKey(sum - k)) {
//                maxLen = Math.max(maxLen, i - sumToIndexMap.get(sum - k));
//            }

            if (sumToIndexMap.containsKey(sum - k)) {
                maxLen = Math.max(maxLen, i - sumToIndexMap.get(sum - k));
            }

            if (!sumToIndexMap.containsKey(sum)) {
                sumToIndexMap.put(sum, i);
            }
        }
        return maxLen;
    }

}
