package com.company.amazon.oa;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 给定四个商品A,B,C,D。 然后有四个list，分别代表四个商品的不同价格。比如ListA, ListB, ListC, ListD。
 * 然后给你一个budget，问你不超过这个budget，每个商品买一个，一共有多少种买法。
 * 比如 [1,2],[2,3],[4],[1,2,3], budget = 10
 * 就有8种买法
 */
public class ShoppingOption {

    //Second approach with two sum
    public static int wayOfShopping(int[][] prods, int budget) {
        List<Integer> list1 = union(prods[0], prods[1], budget);
        List<Integer> list2 = union(prods[2], prods[3], budget);

        int res = 0;
        int index1 = 0;
        int index2 = list2.size() - 1;

        while (index1 < list1.size() && index2 >= 0) {
            int sum = list1.get(index1) + list2.get(index2);
            if (sum <= budget) {
                res += index2 + 1;
                index1++;
            } else {
                index2--;
            }
        }

        return res;
    }

    private static List<Integer> union(int[] a, int[] b, int target) {
        List<Integer> uList = new ArrayList<>();
        for (int i : a) {
            for (int j : b) {
                if (i + j <= target) {
                    uList.add(i + j);
                }
            }
        }

        Collections.sort(uList);
        return uList;
    }


//    First approach with priority queue
//     public static int wayOfShopping(int[][] prods, int budget) {
//         for (int i = 0; i < prods.length; i++) {
//             Arrays.sort(prods[i]);
//         }
//
//         int sum = 0;
//         for (int i = 0; i < prods.length; i++) {
//             sum += prods[i][0];
//         }
//
//         PriorityQueue<Option> pq = new PriorityQueue<Option>((a, b) -> a.getSum() - b.getSum());
//
//         int res = 0;
//         pq.add(new Option(sum, 0, 0));
//
//         while (!pq.isEmpty()) {
//             Option opt = pq.poll();
//             if (opt.getSum() > budget) break;
//             res++;
//             for (int row = opt.getRow(); row < 4; row++) {
//                 int col = (row == opt.getRow()) ? opt.getCol() : 0;
//                 if (col + 1 < prods[row].length) {
//                     pq.add(new Option(opt.getSum() - prods[row][col] + prods[row][col + 1], row, col + 1));
//                 }
//             }
//         }
//
//         return res;
//     }

//     public static void main(String[] args) {
//         int[][] data = new int[][]{{1,2},{2,3},{4,5},{1,2,3}};//should return 12
//         int budget = 10;

//         System.out.println(wayOfShopping(data, budget));
//     }

//     static class Option {
//         int sum;
//         int row;
//         int col;

//         public Option(int sum, int row, int col) {
//             this.sum = sum;
//             this.row = row;
//             this.col = col;
//         }

//         public int getSum() {
//             return this.sum;
//         }

//         public int getRow() {
//             return this.row;
//         }

//         public int getCol() {
//             return this.col;
//         }
//    }
}