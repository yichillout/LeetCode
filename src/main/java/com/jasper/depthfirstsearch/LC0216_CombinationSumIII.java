package com.jasper.depthfirstsearch;

import java.util.ArrayList;
import java.util.List;

public class LC0216_CombinationSumIII {

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        helper(result, new ArrayList<>(), 1, 9, n, k);
        return result;
    }

    public void helper(List<List<Integer>> result, List<Integer> path, int start, int n, int target, int k) {
        if (path.size() == k && target == 0) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i <= n; i++) {
            if (target >= i && path.size() < k) {
                path.add(i);
                helper(result, path, i + 1, n, target - i, k);
                path.remove(path.size() - 1);
            }
        }
    }
}
