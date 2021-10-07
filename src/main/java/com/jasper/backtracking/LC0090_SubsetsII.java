package com.jasper.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC0090_SubsetsII {

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        Arrays.sort(nums);
        helper(0, path, result, nums);
        return result;
    }

    public static void helper(int start, List<Integer> path, List<List<Integer>> result, int[] nums) {
        result.add(new ArrayList<>(path));

        for (int i = start; i < nums.length; i++) {
            if (i == start || nums[i] != nums[i - 1]) {
                path.add(nums[i]);
                helper(i + 1, path, result, nums);
                path.remove(path.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 2};
        subsetsWithDup(nums);
    }

}
