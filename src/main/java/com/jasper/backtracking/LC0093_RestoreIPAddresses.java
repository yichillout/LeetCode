package com.jasper.backtracking;

import java.util.ArrayList;
import java.util.List;

public class LC0093_RestoreIPAddresses {

	public List<String> restoreIpAddresses(String s) {
		List<String> result = new ArrayList<>();
		dfs(s, new ArrayList<String>(), result);
		return result;
	}

	private void dfs(String s, List<String> path, List<String> result) {

		if (path.size() > 4) {
			return;
		}

		if (s.equals("") && path.size() == 4) {
			String str = "";
			for (String p : path) {
				str += p + ".";
			}
			result.add(str.substring(0, str.length() - 1));
			return;
		}

		for (int i = 1; i <= s.length() && i <= 3; i++) {
			String ss = s.substring(0, i);

			if (ss.startsWith("0") && ss.length() > 1) {
				continue;
			}
			int num = Integer.parseInt(ss);
			if (num >= 0 && num <= 255) {
				path.add(ss);
				dfs(s.substring(i), path, result);
				path.remove(path.size() - 1);
			}
		}

	}
}
