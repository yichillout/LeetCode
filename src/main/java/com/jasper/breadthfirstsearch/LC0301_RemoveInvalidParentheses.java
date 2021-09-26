package com.jasper.breadthfirstsearch;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class LC0301_RemoveInvalidParentheses {

    // solution 1 : DFS
    public static List<String> removeInvalidParentheses1(String s) {
        List<String> res = new ArrayList<>();
        char[] check = new char[]{'(', ')'};
        dfs(s, res, check, 0, 0);
        return res;
    }

    public static void dfs(String s, List<String> res, char[] check, int last_i, int last_j) {
        int count = 0;
        int i = last_i;
        while (i < s.length() && count >= 0) {
            if (s.charAt(i) == check[0]) {
                count++;
            }
            if (s.charAt(i) == check[1]) {
                count--;
            }
            i++;
        }

        if (count >= 0) {
            String reversed = new StringBuffer(s).reverse().toString();
            if (check[0] == '(') {
                dfs(reversed, res, new char[]{')', '('}, 0, 0);
            } else {
                res.add(reversed);
            }
        } else {
            i -= 1;
            for (int j = last_j; j <= i; j++) {
                if (s.charAt(j) == check[1] && (j == last_j || s.charAt(j - 1) != check[1])) {
                    dfs(s.substring(0, j) + s.substring(j + 1, s.length()), res, check, i, j);
                }
            }
        }
    }


    // solution 2 : BFS
    public List<String> removeInvalidParentheses(String s) {

        List<String> result = new ArrayList<>();
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        queue.add(s);
        visited.add(s);

        while (!queue.isEmpty()) {

            int size = queue.size();

            if (result.size() != 0) {
                break;
            }

            for (int i = 0; i < size; i++) {
                String str = queue.poll();

                if (isValid(str)) {
                    result.add(str);
                }

                for (int j = 0; j < str.length(); j++) {
                    String next = str.substring(0, j) + str.substring(j + 1);
                    if (!visited.contains(next)) {
                        queue.add(next);
                        visited.add(next);
                    }
                }
            }
        }

        return result;
    }

	// trick
    public boolean isValid(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            char s = str.charAt(i);
            if (s == '(') {
                count++;
            } else if (s == ')') {
                count--;
            }

            if (count < 0) {
                return false;
            }
        }

        return count == 0;
    }
}
