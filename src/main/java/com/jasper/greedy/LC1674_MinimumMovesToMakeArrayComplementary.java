package com.jasper.greedy;

public class LC1674_MinimumMovesToMakeArrayComplementary {


    /**
     *         [3,5] |          ▼               ▼   ▲           ▲  |
     *         [2,3] |      ▼       ▼   ▲               ▲          |
     *         [1,2] |  ▼   ▼   ▲                   ▲              |
     *            ---|---------------------------------------------|---
     * [3,2,1,2,3,5] |  ▼   ▼▼  ▼▲  ▼   ▲       ▼   ▲▲  ▲       ▲  |
     *            ---|---------------------------------------------|---
     * prefix-sum(0) | -1  -3  -3  -4  -3  -3  -4  -2  -1  -1   0  | (starts with 0)
     * prefix-sum(6) |  5   3   3   2   3   3   2   4   5   5   6  | (starts with 6)
     *            ---|---------------------------------------------|---
     *              1|  2   3   4   5   6   7   8   9   10  11  12 |13
     */

    public int minMoves(int[] nums, int limit) {

        if (nums == null || nums.length <= 2) {
            return 0;
        }

        int[] memo = new int[limit * 2 + 2];

        int n = nums.length;
        for (int i = 0; i < n / 2; i++) {
            int l = nums[i];
            int r = nums[n - 1 - i];

            --memo[Math.min(l, r) + 1];
            --memo[l + r];
            ++memo[l + r + 1];
            ++memo[Math.max(l, r) + limit + 1];

        }

        int result = n;
        int cur = n;
        for (int i = 2; i <= limit * 2; i++) {
            cur += memo[i];
            result = Math.min(result, cur);
        }

        return result;
    }

    public static void main(String[] args) {

    }
}
