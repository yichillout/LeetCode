package com.jasper.array;

/*
 * 	test case :            3,4,-1,1
 *  finally it will become 1,4,3,-1
 *  at the position of -1, it should be 2
 *  A[i] != (i + 1)
 *
 * */

import java.util.Arrays;

public class LC0041_FirstMissingPositive {


    // solution 1 : use boolean array     time:O(n)    space:O(1)
    public static int firstMissingPositive1(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                swap(nums, nums[i] - 1, i);
            }
        }

        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        return n + 1;
    }

    public static void swap(int[] nums, int x, int y) {
        int tmp = nums[x];
        nums[x] = nums[y];
        nums[y] = tmp;
    }

    /**
     * solution 2 : use boolean array     time:O(n)    space:O(n)
     *          0   1  2  3  4   5
     * nums:   [1, -1, 2, 3, 5, -3]
     * flags:  [t,  t, t, f, t,  f]
     * return the first index of false
     */

    public int firstMissingPositive2(int[] nums) {
        boolean[] flags = new boolean[nums.length];

        for (int num : nums) {
            if (num - 1 >= 0 && num - 1 < flags.length) {
                flags[num - 1] = true;
            }
        }

        for (int i = 0; i < flags.length; i++) {
            if (!flags[i]) {
                return i + 1;
            }
        }

        return nums.length + 1;
    }

    // solution 3 : sorting
    public int firstMissingPositive3(int[] nums) {
        Arrays.sort(nums);

        int index = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            return 1;
        }

        int result = 1;
        while (index < nums.length) {
            if (nums[index] == result) {
                index++;
                while (index < nums.length && nums[index - 1] == nums[index]) {
                    index++;
                }
                result++;
            } else {
                return result;
            }
        }

        return nums[nums.length - 1] + 1;
    }

    public static void main(String[] args) {
        int[] nums = {0, 2, 2, 1, 1};
        System.out.println(firstMissingPositive1(nums));
    }
}
