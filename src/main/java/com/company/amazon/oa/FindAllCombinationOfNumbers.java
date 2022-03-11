package com.company.amazon.oa;

import java.util.ArrayList;
import java.util.List;

//Find all combination of numbers that Sum to a target
//Given a positive integer, target, print all possible combination of positive integers that sum up to the target number
//For example, if we are given input '5', these are the possible sum combinations:
// [1, 1, 1, 1, 1]
// [1, 1, 1, 2]
// [1, 1, 3]
// [1, 2, 2]
// [1, 4]
// [2, 3]
public class FindAllCombinationOfNumbers {

    public static void main(String[] args) {
        int target = 5;
        List<List<Integer>> res = combination(target);
        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i));
        }
    }

    public static List<List<Integer>> combination(int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        caculateHelper(target, 0, 1, res, path);
        return res;
    }

    private static void caculateHelper(int target, int curSum, int start, List<List<Integer>> res, List<Integer> path) {
        if (curSum == target) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i < target; i++) {
            if (curSum + i <= target) {
                path.add(i);
                caculateHelper(target, curSum + i, i, res, path);
                path.remove(path.size() - 1);
            } else {
                return;
            }
        }
    }
}