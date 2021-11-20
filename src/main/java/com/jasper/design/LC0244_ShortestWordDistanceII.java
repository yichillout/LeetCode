package com.jasper.design;

import java.util.*;

class WordDistance {

    Map<String, List<Integer>> positionMap;

    public WordDistance(String[] wordsDict) {

        positionMap = new HashMap<>();

        for (int i = 0; i < wordsDict.length; i++) {
            if (!positionMap.containsKey(wordsDict[i])) {
                positionMap.put(wordsDict[i], new ArrayList<>());
            }
            positionMap.get(wordsDict[i]).add(i);
        }
    }

    public int shortest(String word1, String word2) {

        int i = 0;
        int j = 0;

        int min = Integer.MAX_VALUE;

        List<Integer> indexes1 = positionMap.get(word1);
        List<Integer> indexes2 = positionMap.get(word2);

        while (i < indexes1.size() && j < indexes2.size()) {
            int index1 = indexes1.get(i);
            int index2 = indexes2.get(j);

            if (index1 < index2) {
                min = Math.min(min, index2 - index1);
                i++;
            } else {
                min = Math.min(min, index1 - index2);
                j++;
            }
        }

        return min;
    }
}

public class LC0244_ShortestWordDistanceII {

    public static void main(String[] args) {
        String[] words = {"practice", "makes", "perfect", "coding", "makes"};
        WordDistance wordDistance = new WordDistance(words);
        System.out.println(wordDistance.shortest("coding", "practice"));
        System.out.println(wordDistance.shortest("makes", "coding"));
    }
}
