package com.company.amazon.oa;

public class GroupDigit {

    public static int minMoves(int n, int arr[]) {
        int indexForZero = 0;
        int indexForOne = 0;

        int countForZero = 0;
        int countForOne = 0;

        for (int i = 0; i < n; i++) { //Go from the left side
            if (arr[i] == 0) {
                countForZero = Math.abs(i - indexForZero);
                indexForZero++;
            }
        }
        for (int i = 0; i < n; i++) { //Go from the left side
            if (arr[i] == 1) {
                countForOne = Math.abs(i - indexForOne);
                indexForOne++;
            }
        }
        return Math.min(countForOne, countForZero);
    }

    public static void main(String[] args) {
        System.out.println(minMoves(8, new int[]{1, 0, 1, 1, 0, 0, 0, 1}));
    }
}
