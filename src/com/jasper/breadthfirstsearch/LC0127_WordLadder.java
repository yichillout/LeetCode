package com.jasper.breadthfirstsearch;

import java.util.*;

public class LC0127_WordLadder {

	public static int ladderLength1(String beginWord, String endWord, List<String> wordList) {

		if (wordList == null || wordList.size() == 0 || endWord == null)
			return 0;

		boolean[] isVisited = new boolean[wordList.size()];
		Queue<String> q = new LinkedList<>();

		int level = 1;

		q.offer(beginWord);

		while (!q.isEmpty()) {

			int size = q.size();

			for (int i = 0; i < size; i++) {

				String tmp = q.poll();

				if (endWord.equals(tmp)) {
					return level;
				}

				for (int j = 0; j < wordList.size(); j++) {
					if (!isVisited[j] && isNext(tmp, wordList.get(j))) {
						q.offer(wordList.get(j));
						isVisited[j] = true;
					}
				}
			}

			level++;
		}

		return 0;
	}

	public static boolean isNext(String str1, String str2) {
		int counter = 0;
		for (int i = 0; i < str1.length(); i++) {
			if (str1.charAt(i) != str2.charAt(i)) {
				counter++;
				if (counter > 1) {
					return false;
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {
		String beginWord = "hit";
		String endWord = "cog";
		List<String> wordList = new ArrayList<String>();
		wordList.add("hot");
		wordList.add("dot");
		wordList.add("dog");
		wordList.add("lot");
		wordList.add("log");
		wordList.add("cog");

		System.out.println(ladderLength1(beginWord, endWord, wordList));
	}
}
