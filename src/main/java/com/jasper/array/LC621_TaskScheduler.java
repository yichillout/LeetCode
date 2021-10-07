package com.jasper.array;

public class LC621_TaskScheduler {

    // A B ? ? A B ? ? A B
    // n = 3
    // max = 3
    // maxCount = 2 (A and B)
    // emptySlots = (3 - 1) * (n - (2 - 1))


    public int leastInterval(char[] tasks, int n) {

        int maxCount = 0;
        int max = 0;
        int[] freq = new int[26];

        for (int i = 0; i < tasks.length; i++) {
            char c = tasks[i];
            freq[c - 'A']++;

            if (max == freq[c - 'A']) {
                maxCount++;
            }

            if (max < freq[c - 'A']) {
                max = freq[c - 'A'];
                maxCount = 1;
            }
        }


        int partCount = max - 1;
        int partLength = n - (maxCount - 1);
        int emptySlots = partCount * partLength;
        int availableTasks = tasks.length - max * maxCount;
        int idles = Math.max(0, emptySlots - availableTasks);

        return tasks.length + idles;

    }
}
