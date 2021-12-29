package com.jasper.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC0040_CombinationSumII {

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        helper(result, new ArrayList<>(), candidates, 0, target);
        return result;
    }

    public static void helper(List<List<Integer>> result, List<Integer> path, int[] candidates, int start, int target) {
        if (target == 0) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if ((i == start || candidates[i] != candidates[i - 1]) && target >= candidates[i]) {
                path.add(candidates[i]);
                helper(result, path, candidates, i + 1, target - candidates[i]);
                path.remove(path.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {10, 1, 2, 7, 6, 1, 5};
        List<List<Integer>> result = combinationSum2(nums, 8);

    }
}
