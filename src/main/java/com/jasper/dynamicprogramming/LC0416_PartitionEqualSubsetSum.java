package com.jasper.dynamicprogramming;

public class LC0416_PartitionEqualSubsetSum {

    public boolean canPartition(int[] nums) {
        if (nums == null || nums.length == 0) {
            return true;
        }

        int volumn = 0;

        for (int num : nums) {
            volumn += num;
        }

        if (volumn % 2 != 0) {
            return false;
        }

        volumn /= 2;

        // dp def
        boolean[] dp = new boolean[volumn + 1];

        dp[0] = true;

        for (int i = 1; i <= nums.length; i++) {
            for (int j = volumn; j >= nums[i - 1]; j--) {
                dp[j] = dp[j] || dp[j - nums[i - 1]];
            }

        }

        return dp[volumn];
    }
}
