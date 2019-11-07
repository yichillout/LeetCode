package com.jasper.bitmanipulation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC0078_Subsets {
	
    public static List<List<Integer>> subsets(int[] nums) {

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


	public static void main(String[] args) {
		int[] nums = {1,2,3};
		System.out.println(subsets(nums));
	}
}
