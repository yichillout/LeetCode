package com.jasper.greedy;


public class LC0134_GasStation {

    // solution 1 : two passes
    public int canCompleteCircuit1(int[] gas, int[] cost) {
        //determine if we have a solution
        int total = 0;
        for (int i = 0; i < gas.length; i++) {
            total += gas[i] - cost[i];
        }
        if (total < 0) {
            return -1;
        }

        // find out where to start
        int tank = 0;
        int start = 0;
        for (int i = 0; i < gas.length; i++) {
            tank += gas[i] - cost[i];
            if (tank < 0) {
                start = i + 1;
                tank = 0;
            }
        }
        return start;
    }

    // solution 2 : one pass
    public int canCompleteCircuit2(int[] gas, int[] cost) {
        int sum = 0;
        int total = 0;
        int j = -1;

        for (int i = 0; i < gas.length; i++) {
            sum += gas[i] - cost[i];
            total += gas[i] - cost[i];
            if (sum < 0) {
                j = i;
                sum = 0;
            }
        }

        if (total < 0) {
            return -1;
        } else {
            return j + 1;

        }
    }
}
