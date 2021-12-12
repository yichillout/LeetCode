package com.jasper.array;

import java.util.*;

public class LC0128_LongestConsecutiveSequence {

    // solution 1
    public int longestConsecutive1(int[] nums) {
        int res = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            if (!map.containsKey(n)) {
                int left = map.getOrDefault(n - 1, 0);
                int right = map.getOrDefault(n + 1, 0);
                int sum = left + right + 1;
                map.put(n, sum);

                res = Math.max(res, sum);

                // extend the length to the boundary(s)
                // of the sequence
                // will do nothing if n has no neighbors
                map.put(n - left, sum);
                map.put(n + right, sum);
            } else {
                // duplicates
                continue;
            }
        }

        return res;
    }


    // solution 2
    public int longestConsecutive2(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        Set<Integer> set = new HashSet<Integer>();

        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        int max = 0;

        for (int i = 0; i < nums.length; i++) {

            if (set.contains(nums[i])) {
                set.remove(nums[i]);
                int left = nums[i] - 1;
                int right = nums[i] + 1;
                int localMax = 1;

                while (set.contains(left)) {
                    set.remove(left);
                    localMax++;
                    left--;
                }

                while (set.contains(right)) {
                    set.remove(right);
                    localMax++;
                    right++;
                }

                max = Math.max(max, localMax);
            }
        }

        return max;
    }
}
