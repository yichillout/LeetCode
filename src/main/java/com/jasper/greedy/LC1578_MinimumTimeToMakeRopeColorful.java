package com.jasper.greedy;

public class LC1578_MinimumTimeToMakeRopeColorful {

    public int minCost(String s, int[] cost) {
        int res = 0;
        int maxCost = 0;
        int sumCost = 0;
        int n = s.length();

        for (int i = 0; i < n; ++i) {
            if (i > 0 && s.charAt(i) != s.charAt(i - 1)) {
                res += sumCost - maxCost;
                sumCost = 0;
                maxCost = 0;
            }

            sumCost += cost[i];
            maxCost = Math.max(maxCost, cost[i]);
        }

        res += sumCost - maxCost;

        return res;
    }
}
