package com.jasper.design;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Leaderboard {

    Map<Integer, Integer> map;

    public Leaderboard() {
        map = new HashMap<>();
    }

    public void addScore(int playerId, int score) {
        map.put(playerId, map.getOrDefault(playerId, 0) + score);
    }

    public int top(int K) {
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            pq.offer(entry);
        }

        int res = 0;

        while (K > 0 && !pq.isEmpty()) {
            Map.Entry<Integer, Integer> entry = pq.poll();
            res += entry.getValue();
            K--;
        }

        return res;
    }

    public void reset(int playerId) {
        map.put(playerId, 0);
    }
}

public class LC1244_DesignALeaderboard {
}
