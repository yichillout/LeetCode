package com.jasper.dynamicprogramming;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LC0472_ConcatenatedWords {

	public List<String> findAllConcatenatedWordsInADict(String[] words) {
		List<String> result = new ArrayList<>();
		Set<String> hash = new HashSet<>();
		Set<String> set = new HashSet<>();

		for (String str : words) {
			set.add(str);
		}

		for (int i = 0; i < words.length; i++) {
			if (dfs(words, words[i], 0, 0, hash, set)) {
				result.add(words[i]);
			}
		}
		return result;
	}

	private boolean dfs(String[] words, String word, int index, int count, Set<String> hash, Set<String> set) {

		if (hash.contains(word)) {
			return true;
		}

		if (word.length() == index && count >= 2) {
			hash.add(word);
			return true;
		}

		for (int i = index; i < word.length(); i++) {
			String str = word.substring(index, i + 1);
			if (set.contains(str)) {
				if (dfs(words, word, i + 1, count + 1, hash, set)) {
					return true;
				}
			}
		}

		return false;
	}
}
