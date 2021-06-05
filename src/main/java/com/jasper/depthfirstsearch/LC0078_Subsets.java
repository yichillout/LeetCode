package com.jasper.depthfirstsearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC0078_Subsets {

	// Solution 1 : backtracking
	public static List<List<Integer>> subsets1(int[] num) {

		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (num == null || num.length == 0) {
			return result;
		}

		ArrayList<Integer> list = new ArrayList<Integer>();
		Arrays.sort(num);

		subsetsHelper(result, list, num, 0);

		return result;
	}

	private static void subsetsHelper(List<List<Integer>> result, ArrayList<Integer> list, int[] num, int pos) {

		result.add(new ArrayList<Integer>(list));

		for (int i = pos; i < num.length; i++) {
			list.add(num[i]);
			subsetsHelper(result, list, num, i + 1);
			list.remove(list.size() - 1);
		}
	}

	// Solution 2 : bit manipulation
	public static List<List<Integer>> subsets2(int[] nums) {

		List<List<Integer>> result = new ArrayList<List<Integer>>();
		int N = nums.length;

		for (int i = 0; i < (1 << N); i++) {
			List<Integer> al = new ArrayList<Integer>();
			for (int j = 0; j < N; j++) {
				if ((i & (1 << j)) > 0) {
					al.add(nums[j]);
				}
			}
			result.add(al);
		}
		return result;

	}

}
