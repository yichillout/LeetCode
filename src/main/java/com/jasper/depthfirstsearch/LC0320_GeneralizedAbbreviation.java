package com.jasper.depthfirstsearch;

import java.util.ArrayList;
import java.util.List;

public class LC0320_GeneralizedAbbreviation {

	public List<String> generateAbbreviations(String word) {
		List<String> ret = new ArrayList<String>();
		backtrack(ret, word, 0, "", 0);
		return ret;
	}

	// pos : points to the current character
	// cur : current string formed
	// count : how many letters abbreviated in the current streak
	private void backtrack(List<String> ret, String word, int pos, String cur, int count) {
		if (pos == word.length()) {
			if (count > 0)
				cur += count;
			ret.add(cur);
		} else {
			// to abbreviate
			backtrack(ret, word, pos + 1, cur, count + 1);

			// not abbreviate and append the previous letter or number
			// append the word.charAt(pos) to cur and refresh the count to 0
			if (count > 0) {
				cur = cur + count;
			}
			backtrack(ret, word, pos + 1, cur + word.charAt(pos), 0);
		}
	}
}
