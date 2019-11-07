package com.jasper.backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class TrieNode {
	String word;
	Map<Character, TrieNode> children;

	public TrieNode() {
		this.word = null;
		this.children = new HashMap<Character, TrieNode>();
	}
}

class Trie {

	TrieNode root;

	public Trie() {
		root = new TrieNode();
	}

	public void insert(String word) {
		if (word == null || word.length() == 0)
			return;

		TrieNode cur = root;
		char[] charArray = word.toCharArray();

		for (int i = 0; i < charArray.length; i++) {
			char c = charArray[i];
			if (!cur.children.containsKey(c)) {
				cur.children.put(c, new TrieNode());
			}
			cur = cur.children.get(c);
		}
		cur.word = word;
	}
}

class LC0212_WordSearchII {

	public List<String> findWords(char[][] board, String[] words) {

		List<String> results = new ArrayList<>();
		Trie trie = new Trie();

		int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

		for (String word : words) {
			trie.insert(word);
		}

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				search(board, i, j, trie.root, results, dir);
			}
		}

		return results;
	}

	public void search(char[][] board, int x, int y, TrieNode root, List<String> results, int[][] dir) {

		if (!root.children.containsKey(board[x][y])) {
			return;
		}

		TrieNode child = root.children.get(board[x][y]);

		if (child.word != null) {
			if (!results.contains(child.word)) {
				results.add(child.word);
			}
		}

		char tmp = board[x][y];
		board[x][y] = '#';

		for (int i = 0; i < 4; i++) {
			if (!isValid(board, x + dir[i][0], y + dir[i][1])) {
				continue;
			}
			search(board, x + dir[i][0], y + dir[i][1], child, results, dir);
		}

		board[x][y] = tmp;
	}

	private boolean isValid(char[][] board, int x, int y) {
		if (x < 0 || x >= board.length || y < 0 || y >= board[0].length) {
			return false;
		}
		return board[x][y] != 0;
	}
}
