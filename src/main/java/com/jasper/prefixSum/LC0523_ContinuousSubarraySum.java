package com.jasper.prefixSum;

import java.util.HashMap;
import java.util.Map;

public class LC0523_ContinuousSubarraySum {

    /**
     * @param nums
     * @param k
     * @return
     */

    // https://www.khanacademy.org/computing/computer-science/cryptography/modarithmetic/a/what-is-modular-arithmetic

    // solution 1
    public static boolean checkSubarraySum(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>(); // <remainder, index>
        map.put(0, -1);

        int runningSum = 0;
        for (int i = 0; i < nums.length; i++) {
            runningSum += nums[i];

            if (k != 0) {
                runningSum %= k;
            }

            Integer prev = map.get(runningSum);

            if (prev != null) {
                // has a continuous subarray of size at least two
                // whose elements sum up to a multiple of k
                if (i - prev > 1) {
                    return true;
                }
            } else {
                map.put(runningSum, i);
            }


        }
        return false;
    }


    // solution 2
    public boolean checkSubarraySum2(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return false;
        }

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

    public static void main(String[] args) {
        int[] nums = new int[]{23, 2, 4, 6, 7};
        checkSubarraySum(nums, 6);
    }

    /**
     *  Time Limit Exceeded
     *  94 / 95 test cases passed.
     *
     *  public boolean checkSubarraySum(int[] nums, int k) {
     *         Map<Integer, Integer> map = new HashMap<>();
     *         map.put(-1, 0);
     *
     *         int sum = 0;
     *         for(int i = 0; i < nums.length; i++) {
     *             sum += nums[i];
     *             map.put(i, sum);
     *
     *             for(int j = 0; j <= i; j++) {
     *                 if(i - j < 1) {
     *                     continue;
     *                 }
     *
     *                 if(j == 0 &&  map.get(i) % k == 0) {
     *                     return true;
     *                 } else if((map.get(i) - map.get(j - 1)) % k == 0) {
     *                     return true;
     *                 }
     *             }
     *         }
     *
     *         return false;
     *     }
     */
}
