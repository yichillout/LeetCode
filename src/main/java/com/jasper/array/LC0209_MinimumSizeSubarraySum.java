package com.jasper.array;

public class LC0209_MinimumSizeSubarraySum {

	public int minSubArrayLen(int s, int[] nums) {

        if(s <= 0 || nums == null)
            throw new IllegalArgumentException("Illigal Arguments");

        int l = 0 , r = -1; // nums[l...r]为我们的滑动窗口
        int sum = 0;
        int res = nums.length + 1;

        while(l < nums.length){   // 窗口的左边界在数组范围内,则循环继续

            if(r + 1 < nums.length && sum < s) {
                r++;
                sum += nums[r];
            } else // r已经到头 或者 sum >= s
                sum -= nums[l++];

            if(sum >= s)
                res = Math.min(res, r - l + 1);
        }

        if(res == nums.length + 1)
            return 0;
        return res;
    }

	public static void main(String[] args) {

	}

}
