package com.company.amazon.oa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a list of integers, partition it into two subsets S1 and S2 such that the sum of S1 is greater than that of S2.
 * And also the number of elements in S1 should be minimal.
 * Return S1 in increasing order.
 * Notice if more than one subset A exists, return the one with the maximal sum.
 * <p>
 * Examples:
 * Input:
 * nums = [4, 5, 2, 3, 1, 2]
 * Output:
 * [4, 5]
 * Explanation:
 * We can divide the numbers into two subsets A = [4, 5] and B = [1, 2, 2, 3]. The sum of A is 9 which is greater than the sum of B which is 8.
 * There are other ways to divide but A = [4, 5] is of minimal size of 2.
 *
 * Input:
 * nums = [10, 5, 3, 1, 20]
 * Output:
 * [20]
 *
 * Input:
 * nums = [1, 2, 3, 5, 8]
 * Output:
 * [5, 8]
 */
public class OptimizeBoxWeight {

    public static void main(String[] args) {
        int[] nums = {4, 5, 2, 3, 1, 10, 20};
        int[] res = optimizingBoxWeight(nums);

        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }

    public static int[] optimizingBoxWeight(int[] nums) {
        int sum = 0, right = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }

        Arrays.sort(nums);

        List<Integer> resList = new ArrayList<>();

        for (int i = nums.length - 1; i >= 0; i--) {
            if (right > sum - right) {
                int[] res = new int[resList.size()];
                for (int j = resList.size() - 1; j >= 0; j--) {
                    res[resList.size() - 1 - j] = resList.get(j);
                }
                return res;
            }

            right += nums[i];
            resList.add(nums[i]);
        }

        return new int[0];
    }
}