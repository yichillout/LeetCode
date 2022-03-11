package com.company.amazon.oa;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given a string made up to integers 0 to 9, count the cumber of ways to split the string into prime numbers in the range of 2 to 1000 inclusive,
 * using up all the characters in the string.
 * e.g "31" -> return 1
 * e.g."11373" -> return 6
 * e.g."1147" -> return 1 not 2, cause 1147 > 1000
 */
public class SplitStringToPrimeNumber {

    private static Set<Integer> primes = new HashSet<Integer>();

    public static int wayOfSplit(String input) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        find(input, res, result);
        return res.size();
    }

    private static void find(String input, List<List<Integer>> res, List<Integer> result) {
        if (input.length() == 0) {
            res.add(new ArrayList<Integer>(result));
            System.out.println(result);
            return;
        }
        if (input.charAt(0) == '0') return;
        for (int i = 1; i <= Math.min(input.length(), 3); i++) {
            int num = Integer.parseInt(input.substring(0, i));
            if (isPrime(num)) {
                primes.add(num);
                result.add(num);
                find(input.substring(i), res, result);
                result.remove(result.size() - 1);
            }
        }
    }

    private static boolean isPrime(int num) {
        if (primes.contains(num)) {
            return true;
        } else {
            if (num == 1) {
                return false;
            } else if (num == 2) {
                return true;
            } else if (num % 2 == 0) {
                return false;
            } else {
                for (int i = 3; i < num / 2; i++) {
                    if (num % i == 0) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        SplitStringToPrimeNumber obj = new SplitStringToPrimeNumber();
        System.out.println(obj.wayOfSplit("31"));
        System.out.println(obj.wayOfSplit("1147"));
        System.out.println(obj.wayOfSplit("11373"));
    }
}