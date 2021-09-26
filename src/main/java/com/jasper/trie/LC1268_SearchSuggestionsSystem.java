package com.jasper.trie;

import java.util.*;

public class LC1268_SearchSuggestionsSystem {

    class TrieNode {
        TrieNode[] sub = new TrieNode[26];
        LinkedList<String> suggestion = new LinkedList<>();
    }

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        TrieNode root = new TrieNode();
        for (String p : products) {
            insert(p, root);
        }
        return search(searchWord, root);
    }

    private void insert(String p, TrieNode root) {
        TrieNode t = root;
        for (char c : p.toCharArray()) {
            if (t.sub[c - 'a'] == null) {
                t.sub[c - 'a'] = new TrieNode();
            }
            t = t.sub[c - 'a'];
            t.suggestion.offer(p);
            Collections.sort(t.suggestion);
            if (t.suggestion.size() > 3) {
                t.suggestion.pollLast();
            }
        }
    }

    private List<List<String>> search(String searchWord, TrieNode root) {
        List<List<String>> result = new ArrayList<>();
        TrieNode cur = root;
        for (char c : searchWord.toCharArray()) {
            if (cur != null) {
                cur = cur.sub[c - 'a'];
            }

            if (cur != null) {
                result.add(cur.suggestion);
            } else {
                result.add(new ArrayList<>());
            }
        }
        return result;
    }
}
