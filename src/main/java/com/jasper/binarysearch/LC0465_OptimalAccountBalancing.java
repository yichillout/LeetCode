package com.jasper.binarysearch;

import java.util.HashMap;
import java.util.Map;

public class LC0465_OptimalAccountBalancing {

    public int minTransfers(int[][] transactions) {
        int[] debt = buildDebtArray(transactions); // Debt amount to balance for each person.
        return getMinTransfersAfter(0, debt);
    }

    private int getMinTransfersAfter(int curId, int[] debt) {
        while (curId < debt.length && debt[curId] == 0) {
            curId++;
        }

        // Base case.
        if (curId == debt.length) {
            return 0;
        }

        // Recursive case.
        int minTransactions = Integer.MAX_VALUE;
        for (int i = curId + 1; i < debt.length; i++) {
            if (debt[i] * debt[curId] < 0) {
                debt[i] += debt[curId];
                minTransactions = Math.min(minTransactions, getMinTransfersAfter(curId + 1, debt) + 1);
                debt[i] -= debt[curId];
            }
        }

        return minTransactions;
    }

    private int[] buildDebtArray(int[][] transactions) {
        Map<Integer, Integer> debtMap = new HashMap<>(); // Map person ID to debt amount.

        for (int[] transaction : transactions) {
            int giver = transaction[0];
            int taker = transaction[1];
            int amount = transaction[2];
            debtMap.put(giver, debtMap.getOrDefault(giver, 0) + amount);
            debtMap.put(taker, debtMap.getOrDefault(taker, 0) - amount);
        }

        int[] debt = new int[debtMap.size()];
        int i = 0;
        for (int amount : debtMap.values()) {
            debt[i++] = amount;
        }

        return debt;
    }

    public static void main(String[] args) {
        int[][] transactions = {{0, 1, 10}, {1, 0, 1}, {1, 2, 5}, {2, 0, 5}};
        LC0465_OptimalAccountBalancing lc0465_optimalAccountBalancing = new LC0465_OptimalAccountBalancing();
        lc0465_optimalAccountBalancing.minTransfers(transactions);
    }
}
