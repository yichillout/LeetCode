package com.jasper.slidingwindow;

import com.annotation.Template;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Random;

@Template
public class LC0239_SlidingWindowMaximum {

    // Solution 1
    public int[] maxSlidingWindow1(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];

        if (nums.length == 0) {
            return new int[]{};
        }

        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i - j + 1 < k) {
                continue;
            }

            if (i - j + 1 > k) {
                j++;
            }

            result[j] = getMax(nums, j, i);
        }

        return result;
    }

    private int getMax(int[] nums, int start, int end) {
        int max = nums[start];
        for (int i = start; i <= end; i++) {
            if (max < nums[i])
                max = nums[i];
        }
        return max;
    }

    /**
     * Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
     * Output: [3,3,5,5,6,7]
     * Explanation:
     * Window position                Max
     * ---------------               -----
     * [1  3  -1] -3  5  3  6  7       3
     * 1 [3  -1  -3] 5  3  6  7       3
     * 1  3 [-1  -3  5] 3  6  7       5
     * 1  3  -1 [-3  5  3] 6  7       5
     * 1  3  -1  -3 [5  3  6] 7       6
     * 1  3  -1  -3  5 [3  6  7]      7
     */

    // Solution 2 : dequeue
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        Deque<Integer> dq = new ArrayDeque<>();

        for (int i = 0; i < k - 1; i++) {
            inQueue(dq, nums, i);
        }

        for (int i = k - 1; i < nums.length; i++) {
            inQueue(dq, nums, i);
            res[i - k + 1] = nums[dq.peekFirst()];
            if (dq.peekFirst() == i - k + 1) {
                dq.removeFirst();
            }
        }

        return res;
    }

    public static void inQueue(Deque<Integer> dq, int[] nums, int index) {
        while (!dq.isEmpty() && nums[dq.peekLast()] < nums[index]) {
            dq.removeLast();
        }
        dq.addLast(index);
    }

    private static void inQueue(int[] nums, Deque<Integer> dq, int pos) {
        while (!dq.isEmpty() && nums[dq.peekLast()] < nums[pos]) {
            dq.removeLast();
        }
        dq.addLast(pos);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        maxSlidingWindow(nums, 3);


        Deque<String> deque = new LinkedList<>();
        deque.offerLast("A"); // A
        deque.offerLast("B"); // A <- B
        deque.offerFirst("C"); // C <- A <- B
        System.out.println(deque.pollFirst()); // C, 剩下A <- B
        System.out.println(deque.pollLast()); // B, 剩下A
        System.out.println(deque.pollFirst()); // A
        System.out.println(deque.pollFirst()); // null
    }
}
