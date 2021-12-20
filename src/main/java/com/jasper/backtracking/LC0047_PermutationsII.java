package com.jasper.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC0047_PermutationsII {


    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        helper(result, new ArrayList<>(), nums, new boolean[nums.length]);
        return result;
    }

    public void helper(List<List<Integer>> result, List<Integer> path, int[] nums, boolean[] visited) {
        if(path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }

        for(int i = 0; i < nums.length; i++) {
            if(visited[i]) {
                continue;
            }

            if (i > 0 && nums[i - 1] == nums[i] && !visited[i - 1]) {
                continue;
            }


            visited[i] = true;
            path.add(nums[i]);
            helper(result, path, nums, visited);
            visited[i] = false;
            path.remove(path.size() - 1);
        }
    }

    public void dfs(List<List<Integer>> list, boolean[] used, int[] nums, List<Integer> tmp) {
        if (tmp.size() == nums.length) {
            list.add(new ArrayList(tmp));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }

            /**
             *  make sure the previous same number is used, then we can use the current!!
             *   [1a, 1b, 2a]
             *   1a -> 1b -> 2a
             *   1a -> 2a -> 1b
             *   1b -> 1a -> 2a (1a should be used before 1b)
             */
            if (i > 0 && nums[i - 1] == nums[i] && !used[i - 1]) {
                continue;
            }
            tmp.add(nums[i]);
            used[i] = true;
            dfs(list, used, nums, tmp);
            tmp.remove(tmp.size() - 1);
            used[i] = false;
        }

    }

}
