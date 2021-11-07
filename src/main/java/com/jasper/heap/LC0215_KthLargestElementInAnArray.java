package com.jasper.heap;

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

    // solution 2 : quick select
    public int findKthLargest2(int[] nums, int k) {
        return helper2(nums, 0, nums.length - 1, nums.length - k + 1);
    }

    public int helper2(int[] nums, int start, int end, int k) { // k -> the Kth
        int pivot = nums[start];
        int i = start + 1;
        int j = start + 1;

        while (i <= end) {
            if (nums[i] <= pivot) {
                swap(nums, i, j);
                j++;
            }
            i++;
        }

        j--;

        swap(nums, start, j);

        if (j - start + 1 == k) {
            return nums[j];
        } else if (j - start + 1 < k) {
            return helper2(nums, j + 1, end, k - (j - start + 1));
        } else {
            return helper2(nums, start, j - 1, k);
        }
    }

    // solution 3 : quick select
    public int findKthLargest3(int[] nums, int k) {
        return helper3(nums, 0, nums.length - 1, nums.length - k);
    }

    public int helper3(int[] nums, int start, int end, int k) { // k -> index
        int pivot = nums[start];
        int i = start + 1;
        int j = start + 1;

        while (i <= end) {
            if (nums[i] <= pivot) {
                swap(nums, i, j);
                j++;
            }
            i++;
        }

        j--;

        swap(nums, start, j);

        if (j == k) {
            return nums[j];
        } else if (j < k) {
            return helper3(nums, j + 1, end, k);
        } else {
            return helper3(nums, start, j - 1, k);
        }
    }

    public void swap(int[] nums, int x, int y) {
        int tmp = nums[x];
        nums[x] = nums[y];
        nums[y] = tmp;
    }

}
