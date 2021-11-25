package com.jasper.backtracking;

public class LC0494_TargetSum {

    public int findTargetSumWays(int[] nums, int target) {
        return helper(nums, 0, 0, target);
    }

    public int helper(int[] nums, int index, int sum, int target) {
        if (index == nums.length) {
            if (target == sum) {
                return 1;
            }
            return 0;
        }

        int result = 0;

        result += helper(nums, index + 1, sum + nums[index], target);
        result += helper(nums, index + 1, sum - nums[index], target);

        return result;
    }
}
