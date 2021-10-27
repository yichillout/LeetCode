package com.jasper.math;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LC0296_BestMeetingPoint {

    // solution 1 : with sorting O(mnlogmn)
    public static int minTotalDistance1(int[][] grid) {
        List<Integer> rows = new ArrayList<>(), cols = new ArrayList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    rows.add(i);
                    cols.add(j);
                }
            }
        }
        Collections.sort(cols);
        return getMinDist(rows) + getMinDist(cols);
    }

    private static int getMinDist(List<Integer> list) {

        if (list == null || list.size() == 0)
            return Integer.MAX_VALUE;

        int median = list.get(list.size() / 2);

        int minDist = 0;

        for (int idx : list) {
            if (idx < median)
                minDist += median - idx;
            else
                minDist += idx - median;
        }

        return minDist;
    }

    // solution 2 : without sorting O(mnlogmn) to O(mn)
    public int minTotalDistance2(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        List<Integer> I = new ArrayList<Integer>();
        List<Integer> J = new ArrayList<Integer>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    I.add(i);
                }
            }
        }
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < m; i++) {
                if (grid[i][j] == 1) {
                    J.add(j);
                }
            }
        }
        return minTotalDistance(I) + minTotalDistance(J);
    }

    public int minTotalDistance(List<Integer> grid) {
        int i = 0;
        int j = grid.size() - 1;
        int sum = 0;
        while (i < j) {
            sum += grid.get(j) - grid.get(i);
            i++;
            j--;
        }
        return sum;
    }

    // solution 3 (Time Limit Exceeded)
    public int minTotalDistance3(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        List<int[]> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    list.add(new int[]{i, j});
                }
            }
        }

        int min = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int dis = 0;
                for (int k = 0; k < list.size(); k++) {
                    int[] friend = list.get(k);
                    int num = Math.abs(friend[0] - i) + Math.abs(friend[1] - j);
                    if (num != 0) {
                        dis += num;
                    }
                }
                min = dis < min ? dis : min;
            }
        }

        return min;
    }

    public static void main(String[] args) {

        int[][] grid = {
                {1, 0, 0, 0, 1},
                {0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0}};

        System.out.println(minTotalDistance1(grid));

    }

}
