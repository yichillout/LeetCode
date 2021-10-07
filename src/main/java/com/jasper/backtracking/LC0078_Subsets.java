package com.jasper.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC0078_Subsets {

    // Solution 1 : backtracking
    public List<List<Integer>> subsets1(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        helper(0, path, result, nums);
        return result;
    }

    public void helper(int start, List<Integer> path, List<List<Integer>> result, int[] nums) {
        result.add(new ArrayList<>(path));
        for (int i = start; i < nums.length; i++) {
            path.add(nums[i]);
            helper(i + 1, path, result, nums);
            path.remove(path.size() - 1);
        }
    }

    // Solution 2 : bit manipulation
    public static List<List<Integer>> subsets2(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        int N = nums.length;

        for (int i = 0; i < (1 << N); i++) {
            List<Integer> al = new ArrayList<>();
            for (int j = 0; j < N; j++) {
                if ((i & (1 << j)) > 0) {
                    al.add(nums[j]);
                }
            }
            result.add(al);
        }
        return result;

    }

}
