package com.jasper.backtracking;

public class LC0060_PermutationSequence {

	public String getPermutation(int n, int k) {
		StringBuilder builder = new StringBuilder();
		String[] result = { "" };
		int[] count = new int[] { 0 };
		boolean[] used = new boolean[n + 1];
		dfs(result, builder, n, k, used, count);
		return result[0];
	}

	private void dfs(String[] result, StringBuilder builder, int n, int k, boolean[] used, int[] count) {

		if (builder.length() == n) {
			count[0]++;
			if (count[0] == k) {
				result[0] = builder.toString();
			}
			return;
		}

		for (int i = 1; i <= n; i++) {
			if (!used[i]) {
				builder.append(i + "");
				used[i] = true;
				dfs(result, builder, n, k, used, count);
				builder.deleteCharAt(builder.length() - 1);
				used[i] = false;
			}
		}

	}
}
