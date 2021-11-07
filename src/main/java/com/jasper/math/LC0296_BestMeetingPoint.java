package com.jasper.math;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LC0296_BestMeetingPoint {

    // solution 1 : with sorting O(mnlogmn)
    public static int minTotalDistance1(int[][] grid) {
        List<Integer> rows = new ArrayList<>();
        List<Integer> cols = new ArrayList<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    rows.add(i);
                    cols.add(j);
                }
            }
        }

        Collections.sort(cols);

        return getMin(rows) + getMin(cols);
    }

    // solution 2 : without sorting O(mn)
    public int minTotalDistance(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        List<Integer> rowBuilders = new ArrayList<>();
        List<Integer> colBuilders = new ArrayList<>();


        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    rowBuilders.add(i);
                }
            }
        }

        for (int j = 0; j < n; j++) {
            for (int i = 0; i < m; i++) {
                if (grid[i][j] == 1) {
                    colBuilders.add(j);
                }
            }
        }

        return getMin(rowBuilders) + getMin(colBuilders);
    }

    public static int getMin(List<Integer> buildings) {

        int l = 0;
        int r = buildings.size() - 1;

        int sum = 0;
        while (l < r) {
            sum += buildings.get(r) - buildings.get(l);
            r--;
            l++;
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
