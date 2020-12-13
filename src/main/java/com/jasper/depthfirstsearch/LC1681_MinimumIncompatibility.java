package com.jasper.depthfirstsearch;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LC1681_MinimumIncompatibility {

    private static int min = Integer.MAX_VALUE;
    private static int bucketSize = 0;

    public static int minimumIncompatibility(int[] nums, int k) {
        int n = nums.length;
        bucketSize = n / k;

        List<Set<Integer>> sets = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            sets.add(new HashSet<>());
        }

        backtrack(nums, 0, sets, 0);

        return min == Integer.MAX_VALUE ? -1 : min;
    }

    private static void backtrack(int[] nums, int idx, List<Set<Integer>> sets, int acc) {
        if (idx >= nums.length) {
            min = Math.min(min, acc);
            return;
        }

        Set<Set<Integer>> visited = new HashSet<>();

        for (Set<Integer> set : sets) {
            if (set.contains(nums[idx]) || set.size() == bucketSize || visited.contains(set)) {
                continue;
            }

            int impact = computeImpact(set, nums[idx]);

            acc += impact;

            if (acc < min) {
                set.add(nums[idx]);
                backtrack(nums, idx + 1, sets, acc);
                set.remove(nums[idx]);
            }

            acc -= impact;
            visited.add(set);
        }
    }

    private static int computeImpact(Set<Integer> set, int num) {
        if (set.size() == 0) {
            return 0;
        }

        if (set.size() == 1) {
            return Math.abs(num - set.iterator().next());
        }


        int lo = Integer.MAX_VALUE;
        int hi = Integer.MIN_VALUE;

        for (int x : set) {
            lo = Math.min(lo, x);
            hi = Math.max(hi, x);
        }

        if (num < lo) {
            return lo - num;
        }

        if (num > hi) {
            return num - hi;
        }

        return 0;
    }

    public static void main(String[] args) {
        int[] nums = {6, 3, 8, 1, 3, 1, 2, 2};
        int k = 4;
        System.out.println(minimumIncompatibility(nums, k));
    }
}
