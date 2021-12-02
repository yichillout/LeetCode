package com.jasper.trie;

class WordDictionary {

    class TrieNode {
        boolean isWord;
        TrieNode[] children;

        public TrieNode() {
            children = new TrieNode[26];
        }
    }

    TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    // Adds a word into the data structure.
    public void addWord(String word) {
        if (word == null) {
            return;
        }

        TrieNode node = root;

        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
            }
            node = node.children[index];
        }

        node.isWord = true;
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        return search(word, root, 0);
    }

    private boolean search(String word, TrieNode node, int depth) {
        if (node == null) {
            return false;
        }

        if (depth == word.length()) {
            return node.isWord;
        }

        char c = word.charAt(depth);
        if (c != '.') {
            return search(word, node.children[c - 'a'], depth + 1);
        } else {
            for (TrieNode nextNode : node.children) {
                if (search(word, nextNode, depth + 1)) {
                    return true;
                }
            }
        }
        return false;
    }

}

public class LC0211_AddandSearchWordDatastructuredesign {

}
