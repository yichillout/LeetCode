package com.jasper.heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class LC1675_MinimizeDeviationInArray {

    /**
     * [5, 2, 3] => [10, 2, 6]
     * [2, 6 , 10] -> 10 - 2 = 8
     * [2, 5, 6]   ->  6 - 2 = 4
     * [2, 3, 5]   ->  5 - 2 = 3

     * result = 3
     */
    public int minimumDeviation(int[] nums) {

        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());

        int result = Integer.MAX_VALUE;
        int min = Integer.MAX_VALUE;

        for (int num : nums) {
            if (num % 2 == 1) {
                num *= 2;
            }

            if (num < min) {
                min = num;
            }

            pq.add(num);
        }


        while (true) {

            int n = pq.poll();

            if (n - min < result) {
                result = n - min;
            }

            if (n % 2 == 1) {
                break;
            }

            if (n / 2 < min) {
                min = n / 2;
            }
            pq.add(n / 2);
        }


        return result;
    }
}
