package com.jasper.breadthfirstsearch;

import java.util.*;

public class LC0127_WordLadder {

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);

        boolean[] visited = new boolean[wordList.size()];

        int level = 1; // to check when adding to queue

        while (!queue.isEmpty()) {
            int size = queue.size();
            level++; // to check when adding to queue
            for (int i = 0; i < size; i++) {
                String str = queue.poll();
                for (int j = 0; j < wordList.size(); j++) {
                    if (!visited[j] && isNext(str, wordList.get(j))) {
                        visited[j] = true;
                        if (wordList.get(j).equals(endWord)) {
                            return level;
                        }
                        queue.offer(wordList.get(j));
                    }
                }
            }
        }

        return 0;
    }

    public static boolean isNext(String word1, String word2) {
        int count = 0;
        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) != word2.charAt(i)) {
                count++;
                if (count > 1) {
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

        System.out.println(ladderLength(beginWord, endWord, wordList));
    }
}
