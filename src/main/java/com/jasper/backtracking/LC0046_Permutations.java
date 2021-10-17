package com.jasper.backtracking;

import java.util.ArrayList;
import java.util.List;

public class LC0046_Permutations {
	
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        permuteHelper(nums, res, temp, new boolean[nums.length]);
        return res;
    }

    private void permuteHelper(int[] nums, List<List<Integer>> res, List<Integer> temp, boolean[] used) {
        if (nums.length == temp.size()) {
            res.add(new ArrayList<>(temp));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                used[i] = true;
                temp.add(nums[i]);
                permuteHelper(nums, res, temp, used);
                temp.remove(temp.size() - 1);
                used[i] = false;
            }
        }
    }
}
