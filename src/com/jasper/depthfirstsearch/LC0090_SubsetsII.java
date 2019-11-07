package com.jasper.depthfirstsearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC0090_SubsetsII {

	private static List<List<Integer>> list;
	private static List<Integer> al;

	public static List<List<Integer>> subsetsWithDup(int[] nums) {
		list = new ArrayList<List<Integer>>();
		al = new ArrayList<Integer>();
		Arrays.sort(nums);
		count(nums, al, 0);
		return list;
	}

	private static void count(int[] nums, List<Integer> al, int j) {

		list.add(new ArrayList<Integer>(al));

		for (int i = j; i < nums.length; i++) {
			if (i == j || nums[i] != nums[i - 1]) {
				al.add(nums[i]);
				count(nums, al, i + 1);
				al.remove(al.size() - 1);
			}
		}
	}

	public static void main(String[] args) {
		int[] nums = { 1, 2, 2 };
		subsetsWithDup(nums);
	}

}
