package com.jasper.breadthfirstsearch;

import java.util.*;

/**
 * Input: equations = [["a","b"],["b","c"]], values = [2.0,3.0], queries = [["a","c"],["b","a"],["a","e"],["a","a"],["x","x"]]
 * Output: [6.00000,0.50000,-1.00000,1.00000,-1.00000]
 * {a={b=2.0}, b={a=0.5, c=3.0}, c={b=0.3333333333333333}}
 */


public class LC0399_EvaluateDivision {

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        double[] result = new double[queries.size()];

        Map<String, Map<String, Double>> map = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            String str1 = equations.get(i).get(0);
            String str2 = equations.get(i).get(1);

            if (!map.containsKey(str1)) {
                map.put(str1, new HashMap<>());
            }

            if (!map.containsKey(str2)) {
                map.put(str2, new HashMap<>());
            }

            map.get(str1).put(str2, values[i]);
            map.get(str2).put(str1, 1 / values[i]);
        }

        for (int i = 0; i < queries.size(); i++) {
            result[i] = helper(queries.get(i).get(0), queries.get(i).get(1), map, new HashSet<>(), 1.0);
        }

        return result;
    }

    public double helper(String cur, String end, Map<String, Map<String, Double>> map, Set<String> visited, double num) {

        if (!map.containsKey(cur)) {
            return -1.0;
        }

        if (map.get(cur).containsKey(end)) {
            return num * map.get(cur).get(end);
        }

        visited.add(cur);
        for (String next : map.get(cur).keySet()) {
            if (!visited.contains(next)) {
                double result = helper(next, end, map, visited, num * map.get(cur).get(next));
                if (result != -1) {
                    return result;
                }
            }
        }

        return -1.0;
    }
}
