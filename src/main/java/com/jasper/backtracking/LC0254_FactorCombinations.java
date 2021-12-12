package com.jasper.backtracking;

import java.util.ArrayList;
import java.util.List;

public class LC0254_FactorCombinations {

    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> result = new ArrayList<>();
        helper(result, new ArrayList<>(), n, 2);
        return result;
    }

    public void helper(List<List<Integer>> result, List<Integer> path, int n, int start) {
        if (n == 1 && path.size() > 1) { // path.size() is used to remove [1] and one value which value == n
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i <= n; i++) {
            if (n % i == 0) {
                path.add(i);
                helper(result, path, n / i, i);
                path.remove(path.size() - 1);
            }
        }
    }
}
