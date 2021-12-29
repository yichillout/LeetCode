package com.jasper.array;

public class LC0053_MaximumSubarray {

    // solution 1 : space O(n)
    public int maxSubArray1(int[] nums) {
        int sum = 0;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            max = Math.max(max, sum);

            if (sum < 0) {
                sum = 0;
            }
        }

        return max;
    }


    // solution 2 : space O(n)
    public static int maxSubArray2(int[] nums) {

        int[] res = new int[nums.length];
        int max = Integer.MIN_VALUE;
        res[0] = nums[0];

        for (int i = 1; i < res.length; i++) {
            if (res[i - 1] > 0) {
                res[i] = res[i - 1] + nums[i];
            } else {
                res[i] = nums[i];
            }
        }

        for (int i = 0; i < res.length; i++) {
            if (res[i] > max) {
                max = res[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        // res: [-2, 1, -2, 4, 3, 5, 6, 1, 5]

        System.out.println(maxSubArray2(nums));
    }

}
