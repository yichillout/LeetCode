package com.jasper.dynamicprogramming;

public class LC0072_EditDistance {

	public static int minDistance(String word1, String word2) {
		int m = word1.length();
		int n = word2.length();

		if (m == 0)
			return n;
		if (n == 0)
			return m;

		int[][] distance = new int[m + 1][n + 1]; // m+1, n+1

		for (int i = 0; i < distance.length; i++) {
			distance[i][0] = i;
		}

		for (int j = 0; j < distance[0].length; j++) {
			distance[0][j] = j;
		}

		for (int i = 1; i < distance.length; i++) {
			for (int j = 1; j < distance[0].length; j++) {
				if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
					distance[i][j] = distance[i - 1][j - 1];
				} else {
					distance[i][j] = Math.min(distance[i - 1][j], Math.min(
							distance[i - 1][j - 1], distance[i][j - 1])) + 1;
				}
			}
		}
		return distance[m][n];
	}

	public static void main(String[] args) {
		System.out.println(minDistance("b", "a"));
	}
}
