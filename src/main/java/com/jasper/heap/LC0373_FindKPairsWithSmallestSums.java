package com.jasper.heap;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class LC0373_FindKPairsWithSmallestSums {

    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {

        PriorityQueue<int[]> que = new PriorityQueue<>((a, b) -> a[0] + a[1] - b[0] - b[1]);

        List<int[]> res = new ArrayList<>();

        if (nums1.length == 0 || nums2.length == 0 || k == 0) {
            return res;
        }

        int i = 0;
        while (i < nums1.length && i < k) {
            que.offer(new int[]{nums1[i], nums2[0], 0});
            i++;
        }

        int count = 0;

        while (!que.isEmpty() && count < k) {
            int[] cur = que.poll();

            res.add(new int[]{cur[0], cur[1]});
            
            if (cur[2] == nums2.length - 1) {
                continue;
            }

            que.offer(new int[]{cur[0], nums2[cur[2] + 1], cur[2] + 1});
            count++;
        }

        return res;
    }
}
