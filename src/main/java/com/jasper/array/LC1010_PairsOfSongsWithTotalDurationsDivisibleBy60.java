package com.jasper.array;

import com.annotation.ImportantExample;

import java.util.HashMap;
import java.util.Map;

@ImportantExample
public class LC1010_PairsOfSongsWithTotalDurationsDivisibleBy60 {

    /**
     * Input: time = [30,20,150,100,40]
     * Output: 3
     * Explanation: Three pairs have a total duration divisible by 60:
     * (time[0] = 30, time[2] = 150): total duration 180
     * (time[1] = 20, time[3] = 100): total duration 120
     * (time[1] = 20, time[4] = 40): total duration 60
     */
    public int numPairsDivisibleBy60(int[] time) {
        Map<Integer, Integer> freqs = new HashMap<>();
        int sum = 0;

        for (int t : time) {
            t %= 60;
            sum += freqs.getOrDefault((60 - t) % 60, 0);
            freqs.put(t, freqs.getOrDefault(t, 0) + 1);
        }

        return sum;
    }
}
