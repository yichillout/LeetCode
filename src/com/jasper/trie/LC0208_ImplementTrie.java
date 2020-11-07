package com.jasper.trie;

import java.util.HashMap;
import java.util.Map;

class Trie {

    class TrieNode {
        boolean isWord;
        Map<Character, TrieNode> children;

        public TrieNode() {
            this.isWord = false;
            this.children = new HashMap<>();
        }
    }

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
        cur.isWord = true;
    }

    public boolean search(String word) {
        char[] charArray = word.toCharArray();

        TrieNode cur = root;

        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];
            if (!cur.children.containsKey(c)) {
                return false;
            }
            cur = cur.children.get(c);
        }

        return cur.isWord;
    }

    public boolean startsWith(String prefix) {
        char[] charArray = prefix.toCharArray();

        TrieNode cur = root;

        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];
            if (!cur.children.containsKey(c)) {
                return false;
            }
            cur = cur.children.get(c);
        }

        return true;
    }
}

public class LC0208_ImplementTrie {

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("log");
        trie.insert("lol");
        trie.insert("lo");
        System.out.println(trie.search("log"));
    }
}
