package com.jasper.greedy;


public class LC0277_FindTheCelebrity {

    // mock method
    public boolean knows(int i, int j) {
        return true;
    }

    public int findCelebrity(int n) {
        int candidate = 0;

        for (int i = 1; i < n; i++) {
            if (knows(candidate, i)) {
                candidate = i;
            }
        }

        for (int i = 0; i < n; i++) {
            if (candidate != i) {
                // knows(result, i) ===>   0 -> 1 and 1 -> 0
                if (!knows(i, candidate) || knows(candidate, i)) {
                    return -1;
                }
            }
        }

        return candidate;
    }
}
