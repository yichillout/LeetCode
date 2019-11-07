package com.jasper.array;


//http://www.cnblogs.com/yrbbest/p/4491635.html
public class LC0167_TwoSumIIInputArrayissorted {

	public int[] twoSum(int[] numbers, int target) {
		int[] res = { -1, -1 };
		if (numbers == null || numbers.length == 0) {
			return res;
		}
		int lo = 0, hi = numbers.length - 1;
		while (lo <= hi) {
			int sum = numbers[lo] + numbers[hi];
			if (sum < target) {
				lo++;
			} else if (sum > target) {
				hi--;
			} else {
				res[0] = lo + 1;
				res[1] = hi + 1;
				return res;
			}
		}
		return res;
	}

	public static void main(String[] args) {

	}

}
