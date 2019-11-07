package com.jasper.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class LC0219_ContainsDuplicateII {

	public static boolean containsNearbyDuplicate(int[] nums, int k) {

        if (nums.length <= 1) {
            return false;
        }

        HashSet<Integer> hashSet = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (i > k) {
                hashSet.remove(nums[i - k - 1]);
            }
            if (!hashSet.add(nums[i])) {
                return true;
            }
        }

        return false;
    }

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 4, 5, 2 };
		System.out.println(containsNearbyDuplicate(nums, 4));
	}

}
