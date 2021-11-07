package com.jasper.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC1868_ProductOfTwoRunLengthEncodedArrays {

    public List<List<Integer>> findRLEArray(int[][] encoded1, int[][] encoded2) {

        int index1 = 0;
        int index2 = 0;
        int freq1 = 0;
        int freq2 = 0;
        int p = 0;
        int len1 = encoded1.length;
        int len2 = encoded2.length;
        List<int[]> lst = new ArrayList<>();

        while (index1 < len1 && index2 < len2) {
            freq1 = encoded1[index1][1];
            freq2 = encoded2[index2][1];
            p = encoded1[index1][0] * encoded2[index2][0];
            if (freq1 == freq2) {
                lst.add(new int[]{p, freq1});
                index1++;
                index2++;
            } else if (freq1 < freq2) {
                lst.add(new int[]{p, freq1});
                encoded2[index2][1] = freq2 - freq1;
                index1++;
            } else {
                lst.add(new int[]{p, freq2});
                encoded1[index1][1] = freq1 - freq2;
                index2++;
            }
        }

        List<List<Integer>> res = new ArrayList<>();

        int[] cur = lst.get(0);
        for (int i = 1; i < lst.size(); i++) {
            if (lst.get(i)[0] != cur[0]) {
                res.add(Arrays.asList(new Integer[]{cur[0], cur[1]}));
                cur = lst.get(i);
            } else {
                cur[1] += lst.get(i)[1];
            }
        }

        res.add(Arrays.asList(new Integer[]{cur[0], cur[1]}));

        return res;
    }
}
