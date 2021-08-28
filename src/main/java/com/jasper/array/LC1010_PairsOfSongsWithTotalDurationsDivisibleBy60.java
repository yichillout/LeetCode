package com.jasper.array;

import com.annotation.ImportantExample;

import java.util.HashMap;
import java.util.Map;

@ImportantExample
public class LC1010_PairsOfSongsWithTotalDurationsDivisibleBy60 {

    public int numPairsDivisibleBy60(int[] time) {
        Map<Integer, Integer> count = new HashMap<>();
        int ans = 0;
        for (int t : time) {
            int reducedTime = t % 60;
            int other = (reducedTime == 0) ? 0 : 60 - reducedTime;
            ans += count.getOrDefault(other, 0);
            count.put(reducedTime, count.getOrDefault(reducedTime, 0) + 1);
        }
        return ans;
    }
}
