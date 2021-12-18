package com.jasper.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LC1042_FlowerPlantingWithNoAdjacent {

    public int[] gardenNoAdj(int n, int[][] paths) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();

        for (int i = 0; i < n; i++) {
            graph.put(i, new HashSet<>());
        }

        for (int[] path : paths) {
            int x = path[0] - 1; //Due to 1-based indexing
            int y = path[1] - 1; //Due to 1-based indexing
            graph.get(x).add(y);
            graph.get(y).add(x);
        }

        int[] res = new int[n];

        //For each garden
        for (int i = 0; i < n; i++) {
            int[] colors = new int[5]; //Use 5 instead of 4 so we can easily use 1-based indexing of the garden colors
            for (int nei : graph.get(i)) {
                colors[res[nei]] = 1; //Mark the color as used if neighbor has used it before.
            }

            //Now just use a color that has not been used yet
            for (int c = 4; c >= 1; c--) {
                if (colors[c] != 1) { //colors[c] == 0 => the color has not been used yet,
                    res[i] = c;
                }
            }
        }

        return res;

    }
}
