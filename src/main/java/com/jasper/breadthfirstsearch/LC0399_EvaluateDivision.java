package com.jasper.breadthfirstsearch;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * Input: equations = [["a","b"],["b","c"]], values = [2.0,3.0], queries = [["a","c"],["b","a"],["a","e"],["a","a"],["x","x"]]
 * Output: [6.00000,0.50000,-1.00000,1.00000,-1.00000]
 * {a={b=2.0}, b={a=0.5, c=3.0}, c={b=0.3333333333333333}}
 */


public class LC0399_EvaluateDivision {

    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {

        HashMap<String, HashMap<String, Double>> map = new HashMap<>();

        for (int i = 0; i < equations.length; ++i) {

            if (!map.containsKey(equations[i][0]))
                map.put(equations[i][0], new HashMap<String, Double>());

            if (!map.containsKey(equations[i][1]))
                map.put(equations[i][1], new HashMap<String, Double>());

            map.get(equations[i][0]).put(equations[i][1], values[i]);
            map.get(equations[i][1]).put(equations[i][0], 1 / values[i]);
        }

        double[] out = new double[queries.length];

        for (int i = 0; i < queries.length; ++i) {
            if (map.containsKey(queries[i][0]) && map.containsKey(queries[i][1])) {
                if (queries[i][0] == queries[i][1])
                    out[i] = 1.0;
                else {
                    double judg = dfs(queries[i][0], queries[i][1], new HashSet<String>(), map, 1.0);
                    if (judg == 0.0) {
                        out[i] = -1.0;
                    } else {
                        out[i] = judg;
                    }
                }
            } else {
                out[i] = -1.0;
            }
        }

        return out;
    }

    private double dfs(String s, String t, HashSet<String> visited, HashMap<String, HashMap<String, Double>> map,
                       double val) {

        if (map.get(s).containsKey(t))
            return val * map.get(s).get(t);

        double tmp = 0.0;

        for (String neighbor : map.get(s).keySet()) {
            if (!visited.contains(neighbor)) {
                visited.add(neighbor);
                tmp = dfs(neighbor, t, visited, map, val * map.get(s).get(neighbor));
                if (tmp != 0.0)
                    break;
            }
        }

        return tmp;
    }

    public static void main(String[] args) {
        LC0399_EvaluateDivision lc0399_evaluateDivision = new LC0399_EvaluateDivision();
        String[][] equations = new String[][]{{"a", "b"}, {"b", "c"}};
        double[] values = new double[]{2.0, 3.0};
        String[][] queries = {{"a", "c"}, {"b", "a"}, {"a", "e"}, {"a", "a"}, {"x", "x"}};
        System.out.println(Arrays.toString(lc0399_evaluateDivision.calcEquation(equations, values, queries)));
    }

}
