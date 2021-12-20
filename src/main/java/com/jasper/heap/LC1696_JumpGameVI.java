package com.jasper.heap;

import java.util.PriorityQueue;

public class LC1696_JumpGameVI {

    // solution 1 : PriorityQueue
    // https://www.youtube.com/watch?v=M_PzYd59_kk
    public static int maxResult(int[] nums, int k) {
        if (nums.length == 1) {
            return nums[0];
        }

        int max = nums[0];

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        pq.offer(new int[]{0, nums[0]});

        for (int i = 1; i < nums.length; i++) {
            while (pq.peek()[0] < i - k) {
                pq.poll();
            }

            max = nums[i] + pq.peek()[1];
            pq.offer(new int[]{i, max});
        }

        return max;
    }

    public static void main(String[] args) {
        int[] nums = {10, -5, -2, 4, 0, 3};
        maxResult(nums, 3);

        /**
         * int the PriorityQueue
         *  5,17
         *  4,14
         *  3,14
         *  1,5
         *  0,10
         *  2,8
         */
    }
}
