package com.jasper.dynamicprogramming;

import java.util.Arrays;

public class LC0354_RussianDollEnvelopes {

    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes == null || envelopes.length == 0) {
            return 0;
        }

        int n = envelopes.length;
        Arrays.sort(envelopes, (int[] a, int[] b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            } else {
                return a[1] - b[1];
            }
        });


        int[] f = new int[n];
        int[] pi = new int[n];
        int i, j;
        for (i = 0; i < n; i++) {
            f[i] = 1;
            pi[i] = -1;
            for (j = 0; j < i; j++) {
                if (envelopes[j][0] < envelopes[i][0] && envelopes[j][1] < envelopes[i][1]) {
                    f[i] = Math.max(f[i], f[j] + 1);
                    if (f[i] == f[j] + 1) {
                        pi[i] = j;
                    }
                }
            }
        }


        int res = 0;
        j = i;
        for (i = 0; i < n; i++) {
            res = Math.max(res, f[i]);
            if (res == f[i]) {
                j = i;
            }
        }

        while (j != -1) {
            System.out.println("[" + envelopes[j][0] + "," + envelopes[j][1] + "]");
            j = pi[j];
        }

        return res;
    }
}
