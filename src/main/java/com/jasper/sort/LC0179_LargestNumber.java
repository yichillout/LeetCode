package com.jasper.sort;

import java.util.Arrays;
import java.util.Comparator;

public class LC0179_LargestNumber {
	public String largestNumber(int[] nums) {
		Integer[] ints = new Integer[nums.length];

		for (int i = 0; i < nums.length; i++) {
			ints[i] = nums[i];
		}

		Arrays.sort(ints, new Comparator<Integer>() {
			public int compare(Integer n1, Integer n2) {
				// System.out.println(n1 +":"+n2);
				String str1 = String.valueOf(n1);
				String str2 = String.valueOf(n2);
				return (str2 + str1).compareTo(str1 + str2);
			}
		});

		if (ints[0] == 0) {
			return "0";
		}
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < nums.length; i++) {
			sb.append(ints[i]);
		}
		return sb.toString();
	}

}
