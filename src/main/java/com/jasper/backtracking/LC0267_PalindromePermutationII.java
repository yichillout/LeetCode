package com.jasper.backtracking;

import java.util.ArrayList;
import java.util.List;

public class LC0267_PalindromePermutationII {

    public List<String> generatePalindromes(String s) {
        List<String> ans = new ArrayList<>();
        int[] count = new int[256];
        int odds = 0;

        for (char c : s.toCharArray()) {
            count[c]++;
        }

        for (int c : count) {
            if (c % 2 != 0) {
                odds++;
            }
        }

        if (odds <= 1) {
            char center = '#';
            for (int idx = 0; idx < count.length; idx++) {
                if (count[idx] % 2 == 1) {
                    center = ((char) idx);
                    count[idx]--;
                    break;
                }
            }
            generate(ans, count, (center != '#' ? String.valueOf(center) : new String()), s.length());
        }

        return ans;
    }

    private void generate(List<String> ans, int[] count, String build, int len) {
        for (int idx = 0; idx < count.length; idx++) {
            if (count[idx] > 1) {
                count[idx] -= 2;
                generate(ans, count, ((char) idx) + build + ((char) idx), len);
                count[idx] += 2;
            }
        }

        if (build.length() == len) {
            ans.add(build);
        }
    }
}
