package com.jasper.divideandconquer;

import com.annotation.Template;

import java.util.PriorityQueue;

@Template
public class LC0215_KthLargestElementInAnArray {

    // solution 1
    public int findKthLargest1(int[] nums, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<Integer>(k);
        for (int i : nums) {
            q.offer(i);

            if (q.size() > k) {
                q.poll();
            }
        }

        return q.peek();
    }

    // solution 2 利用partition的特性
    public int findKthLargest(int[] nums, int k) {
        return helper(nums, 0, nums.length - 1, nums.length - k + 1);
    }

    private int helper(int[] nums, int s, int e, int k) {
        if (s == e)
            return nums[s];

        int p = nums[s];
        int j = s + 1;
        int i = s + 1;

        while (i <= e) {
            if (nums[i] < p) {
                swap(nums, j, i);
                j++;
            }
            i++;
        }
        j--;

        swap(nums, j, s);

        if (j - s + 1 == k) {
            return nums[j];
        } else if (j - s + 1 < k) {
            return helper(nums, j + 1, e, k - (j - s + 1));
        } else {
            return helper(nums, s, j - 1, k);
        }

    }

    private void swap(int[] nums, int index1, int index2) {
        int tmp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = tmp;
    }

}
