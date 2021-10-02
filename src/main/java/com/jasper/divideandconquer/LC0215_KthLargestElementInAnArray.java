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
    public int findKthLargest2(int[] nums, int k) {
        return helper(nums, 0, nums.length - 1, nums.length - k);
    }

    public int helper(int[] nums, int start, int end, int k) {
        if (start >= end) {
            return nums[end];
        }

        int pivot = nums[start];
        int i = start + 1;
        int j = start + 1;

        while (j <= end) {
            if (nums[j] <= pivot) {
                swap(nums, j, i);
                i++;
            }
            j++;
        }

        i--;
        swap(nums, i, start);

        if (i - start == k) {
            return nums[i];
        } else if (i - start < k) {
            return helper(nums, i + 1, end, k - (i + 1 - start));
        } else {
            return helper(nums, start, i - 1, k);
        }
    }

    private void swap(int[] nums, int index1, int index2) {
        int tmp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = tmp;
    }
}
