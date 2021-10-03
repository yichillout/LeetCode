package com.jasper.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC0040_CombinationSumII {

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        if (candidates == null || candidates.length == 0) {
            return res;
        }

        Arrays.sort(candidates);

        dfs(0, target, res, path, candidates);

        return res;
    }

    public static void dfs(int pos, int target, List<List<Integer>> res, List<Integer> path, int[] candidates) {
        if (target < 0)
            return;

        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = pos; i < candidates.length; i++) {
            if (i == pos || candidates[i] != candidates[i - 1]) {
                path.add(candidates[i]);
                dfs(i + 1, target - candidates[i], res, path, candidates);
                path.remove(path.size() - 1);
            }

        }
    }

    public static void main(String[] args) {
        int[] nums = {10, 1, 2, 7, 6, 1, 5};
        List<List<Integer>> result = combinationSum2(nums, 8);

    }
}
