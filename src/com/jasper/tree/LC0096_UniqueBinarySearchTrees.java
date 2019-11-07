package com.jasper.tree;

public class LC0096_UniqueBinarySearchTrees {
	public static int numTrees(int n) {
		if (n == 0 || n == 1)
			return 1;

		int[] count = new int[n + 1];
		count[0] = 1;
		count[1] = 1;
		for (int i = 2; i <= n; i++) {
			for (int j = 0; j < i; j++) {
				count[i] += count[j] * count[i - j - 1];
			}
		}

		return count[n];
	}

	public static void main(String[] args) {
		System.out.println(numTrees(2));
	}
}
