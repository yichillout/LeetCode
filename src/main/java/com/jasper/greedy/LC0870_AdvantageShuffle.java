package com.jasper.greedy;

import java.util.Arrays;
import java.util.PriorityQueue;

public class LC0870_AdvantageShuffle {

    public int[] advantageCount(int[] A, int[] B) {

        Arrays.sort(A);
        int l = 0;
        int r = A.length - 1;
        int[] result = new int[A.length];

        System.out.println(Arrays.toString(A));

        PriorityQueue<int[]> pq = new PriorityQueue<>((int[] a, int[] b) -> b[0] - a[0]);

        for (int i = 0; i < B.length; i++) {
            pq.offer(new int[]{B[i], i});
        }


        while (!pq.isEmpty()) {
            int cur[] = pq.poll();

            if (A[r] > cur[0]) {
                result[cur[1]] = A[r--];
            } else {
                result[cur[1]] = A[l++];
            }

        }

        return result;
    }
}
