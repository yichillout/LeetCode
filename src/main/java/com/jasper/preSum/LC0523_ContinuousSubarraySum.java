package com.jasper.preSum;

import java.util.HashMap;
import java.util.Map;

public class LC0523_ContinuousSubarraySum {

    /**
     * @param nums
     * @param k
     * @return
     */

    // solution 1
    public static boolean checkSubarraySum(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        int runningSum = 0;
        for (int i = 0; i < nums.length; i++) {
            runningSum += nums[i];

            if (k != 0) {
                runningSum %= k;
            }

            Integer prev = map.get(runningSum);

            if (prev != null) {
                if (i - prev > 1) return true;
            } else {
                map.put(runningSum, i);
            }

            System.out.println(map);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{23, 2, 4, 6, 7};
        checkSubarraySum(nums, 6);
    }

    // solution 2
    public boolean checkSubarraySum2(int[] nums, int k) {
        if (nums == null || nums.length == 0) return false;

        int[] preSum = new int[nums.length + 1];

        for (int i = 1; i <= nums.length; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 2; j <= nums.length; j++) { // j = i + 2 is because question mentions subarray size at least 2
                if (k == 0) {
                    if (preSum[j] - preSum[i] == 0) {
                        return true;
                    }
                } else if ((preSum[j] - preSum[i]) % k == 0) {
                    return true;
                }
            }
        }
        return false;
    }
}
