package com.jasper.breadthfirstsearch;

import java.util.*;

/**
 * Input: equations = [["a","b"],["b","c"]], values = [2.0,3.0], queries = [["a","c"],["b","a"],["a","e"],["a","a"],["x","x"]]
 * Output: [6.00000,0.50000,-1.00000,1.00000,-1.00000]
 * {a={b=2.0}, b={a=0.5, c=3.0}, c={b=0.3333333333333333}}
 */


public class LC0399_EvaluateDivision {

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {

        HashMap<String, Map<String, Double>> map = new HashMap<>();

        for (int i = 0; i < equations.size(); i++) {
            List<String> equation = equations.get(i);

            if (!map.containsKey(equation.get(0))) {
                map.put(equation.get(0), new HashMap<>());
            }

            if (!map.containsKey(equation.get(1))) {
                map.put(equation.get(1), new HashMap<>());
            }

            map.get(equation.get(0)).put(equation.get(1), values[i]);
            map.get(equation.get(1)).put(equation.get(0), 1 / values[i]);
        }

        double[] result = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            result[i] = helper(queries.get(i).get(0), queries.get(i).get(1), map, new HashSet<>(), 1.0);
        }

        return result;

    }

    public double helper(String start, String end, HashMap<String, Map<String, Double>> map, Set<String> visited, double num) {

        if (!map.containsKey(start)) {
            return -1.0;
        }

        if (map.get(start).containsKey(end)) {
            return map.get(start).get(end) * num;
        }

        double result = -1.0;
        visited.add(start);
        for (String neighor : map.get(start).keySet()) {
            if (!visited.contains(neighor)) {
                visited.add(neighor);
                result = helper(neighor, end, map, visited, num * map.get(start).get(neighor));
                visited.remove(neighor);

                if (result != -1) {
                    return result;
                }
            }
        }

        return result;
    }
}
