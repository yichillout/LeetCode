package com.jasper.heap;

import java.util.PriorityQueue;

public class LC1696_JumpGameVI {

    public int maxResult(int[] nums, int k) {

        if (nums.length == 1) {
            return nums[0];
        }
        int ans = Integer.MIN_VALUE;
        int n = nums.length;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);

        pq.offer(new int[]{n - 1, nums[n - 1]});

        for (int i = n - 2; i >= 0; i--) {
            while (pq.peek()[0] > i + k) {
                pq.poll();
            }

            ans = nums[i] + pq.peek()[1];
            pq.offer(new int[]{i, ans});
        }

        return ans;
    }
}
