package com.jasper.design;

import java.util.HashMap;


class FindSumPairs {

    int[] nums1;
    int[] nums2;

    HashMap<Integer, Integer> freq = new HashMap<>();

    public FindSumPairs(int[] nums1, int[] nums2) {
        this.nums1 = nums1;
        this.nums2 = nums2;
        for (int x : nums2) {
            increaseFreq(x, 1);
        }
    }

    private void increaseFreq(int key, int inc) {
        freq.put(key, freq.getOrDefault(key, 0) + inc);
    }

    public void add(int index, int val) {
        increaseFreq(nums2[index], -1);  // Remove old one
        nums2[index] += val;
        increaseFreq(nums2[index], 1);  // Count new one
    }

    public int count(int tot) {
        int ans = 0;
        for (int a : nums1) {
            ans += freq.getOrDefault(tot - a, 0); // a + b = tot -> b = tot - a
        }
        return ans;
    }
}

public class LC1865_FindingPairsWithACertainSum {
    public static void main(String[] args) {
        int[]  nums1 = new int[]{1, 1, 2, 2, 2, 3};
        int[]  nums2 = new int[]{1, 4, 5, 2, 5, 4};
        FindSumPairs findSumPairs = new FindSumPairs(nums1, nums2);
        findSumPairs.count(7);        // return 8; pairs (2,2), (3,2), (4,2), (2,4), (3,4), (4,4) make 2 + 5 and pairs (5,1), (5,5) make 3 + 4
        findSumPairs.add(3, 2);  // now nums2 = [1,4,5,4,5,4]
        findSumPairs.count(8);        // return 2; pairs (5,2), (5,4) make 3 + 5
        findSumPairs.count(4);        // return 1; pair (5,0) makes 3 + 1
        findSumPairs.add(0, 1);  // now nums2 = [2,4,5,4,5,4]
        findSumPairs.add(1, 1);  // now nums2 = [2,5,5,4,5,4]
        findSumPairs.count(7);         // return 11; pairs (2,1), (2,2), (2,4), (3,1), (3,2), (3,4), (4,1), (4,2), (4,4) make 2 + 5 and pairs (5,3), (5,5) make 3 + 4
    }
}
