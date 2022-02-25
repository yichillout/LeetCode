package com.jasper.tree;

public class LC0096_UniqueBinarySearchTrees {

    /**
     *
     *        F(i, n) = G(i-1) * G(n-i)
     *
     *        G(n) = G(0) * G(n-1) + G(1) * G(n-2) + … + G(n-1) * G(0)
     *
     *
     *        G[0]=1
     *        G[1]=1
     *        G[2]=G[0] * G[1] + G[1] * G[0] = 2
     *   root        1             2
     *        G[3]=G[0] * G[2] + G[1] * G[1] + G[2] * G[0] = 6
     *   root        1             2             3
     *
     *
     *      G[4] = G[0] * G[3]
     *           + G[1] * G[2]
     *           + G[2] * G[2]
     *           + G[3] * G[1]
     *           + G[4] * G[0];
     */

    // Solution 1 : DFS
    public int numTrees1(int n) {
        int[] memo = new int[n + 1];
        for (int i = 0; i < memo.length; i++) {
            memo[i] = -1;
        }

        return dfs(n, memo);
    }

    public int dfs(int num, int[] memo) {
        if (num == 0 || num == 1) {
            return 1;
        }

        if (memo[num] != -1) {
            return memo[num];
        }

        int sum = 0;
        for (int i = 1; i <= num; i++) {
            sum += dfs(i - 1, memo) * dfs(num - i, memo);
        }
        memo[num] = sum;
        return sum;
    }

    // Solution 2 : DP
    public static int numTrees2(int n) {
        if (n == 0 || n == 1)
            return 1;

        int[] count = new int[n + 1];
        count[0] = 1;
        count[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                count[i] += count[j] * count[i - j - 1];
            }
        }

        return count[n];
    }

    public static void main(String[] args) {
        System.out.println(numTrees2(2));
    }
}
