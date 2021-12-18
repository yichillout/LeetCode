package com.jasper.twopointers;

public class LC0245_ShortestWordDistanceIII {

    public int shortestWordDistance(String[] wordsDict, String word1, String word2) {

        int index = -1;
        int min = wordsDict.length;

        for (int i = 0; i < wordsDict.length; i++) {
            if (wordsDict[i].equals(word1) || wordsDict[i].equals(word2)) {
                if (index != -1 && (word1.equals(word2) || !wordsDict[index].equals(wordsDict[i]))) {
                    min = Math.min(i - index, min);
                }
                index = i;
            }
        }

        return min;
    }
}
