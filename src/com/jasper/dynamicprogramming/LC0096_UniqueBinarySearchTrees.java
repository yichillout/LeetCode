package com.jasper.dynamicprogramming;

public class LC0096_UniqueBinarySearchTrees {

	public int numTrees(int n) {
		if (n == 0 || n == 1)
			return 1;
		int res[] = new int[n + 1];
		res[0] = 1;
		for (int i = 1; i <= n; i++) {
			for (int j = 0; j < i; j++) {
				res[i] += res[j] * res[i - j - 1];
			}
		}
		return res[n];
	}

}
