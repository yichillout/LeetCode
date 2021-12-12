package com.jasper.prefixSum;

import java.util.HashMap;
import java.util.Map;

public class LC0560_SubarraySumEqualsK {

    /**
     * k = 3
     * nums :          [1, 2, 3, -1, 1]
     * prefixSum :  [0 ,1, 3, 6,  5, 6]
     *                     3-0=3
     *                        6-3=3
     *                               6-3=3
     * map: {0:1,1:1,3:1,5:1,6:2}
     *
     * 1. Hashmap<sum[0,i - 1], frequency>
     * 2. sum[i, j] = sum[0, j] - sum[0, i - 1]   --> sum[0, i - 1] = sum[0, j] - sum[i, j]
     *        k          sum      hashmap-key     -->  hashmap-key   =   sum          k
     */

    public int subarraySum(int[] nums, int k) {
        if(nums == null || nums.length == 0) {
            return 0;
        }

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        int count = 0;

        int sum = 0;
        for(int num : nums) {
            sum += num;
            count += map.getOrDefault(sum - k, 0);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return count;
    }
}
