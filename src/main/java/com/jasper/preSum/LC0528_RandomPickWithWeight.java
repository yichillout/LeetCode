package com.jasper.preSum;

import java.util.Random;

class Solution {

    Random random;
    int[] wSums;

    public Solution(int[] w) {
        random = new Random();
        wSums = new int[w.length];
        int sum = 0;
        for (int i = 0; i < w.length; i++) {
            sum += w[i];
            wSums[i] = sum;
        }
    }

    public int pickIndex() {
        int n = wSums.length;
        int idx = random.nextInt(wSums[n - 1]) + 1;
        int left = 0;
        int right = n - 1;

        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (wSums[mid] < idx) {
                left = mid;
            } else {
                right = mid;
            }
        }

        if(wSums[right] == idx) {
            return right;
        }

        return left;
    }
}


public class LC0528_RandomPickWithWeight {
    public static void main(String[] args) {
        Solution solution = new Solution(new int[]{1, 3, 4});
        solution.pickIndex();
    }

}
