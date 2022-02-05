package com.jasper.prefixSum;

import java.util.Random;

class Solution {

    int[] prefixSums;
    Random random;
    int total;

    /**
     *  input     : [1, 3]
     *  prefixSums: [1, 4]
     *  total     : 4
     *  random.nextInt(total)
     *
     *  0   => 1
     *  2-3 => 4
     *
     *  target = [0, 3]
     *  find the first number greater than target
     */


    public Solution(int[] w) {
        random = new Random();
        total = 0;
        prefixSums = new int[w.length];
        for (int i = 0; i < prefixSums.length; i++) {
            total += w[i];
            prefixSums[i] = total;
        }
    }



    public int pickIndex() {
        int target = random.nextInt(total);

        int l = 0;
        int r = prefixSums.length - 1;

        while (l + 1 < r) {
            int mid = l + (r - l) / 2;
            if (prefixSums[mid] > target) {
                r = mid;
            } else {
                l = mid;
            }
        }

        if (prefixSums[l] > target) {
            return l;
        }

        return r;
    }
}


public class LC0528_RandomPickWithWeight {
    public static void main(String[] args) {
        Solution solution = new Solution(new int[]{1, 3, 4});
        solution.pickIndex();
    }

}
