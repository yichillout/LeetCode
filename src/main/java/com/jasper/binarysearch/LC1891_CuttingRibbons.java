package com.jasper.binarysearch;

public class LC1891_CuttingRibbons {

    public int maxLength(int[] ribbons, int k) {

        int max = Integer.MIN_VALUE;
        for (int ribbon : ribbons) {
            if (ribbon > max) {
                max = ribbon;
            }
        }

        int l = 1;
        int r = max;

        while (l + 1 < r) {
            int mid = l + (r - l) / 2;
            if (isCutPossible(ribbons, mid, k)) {
                l = mid;
            } else {
                r = mid;
            }
        }

        if (isCutPossible(ribbons, r, k)) {
            return r;
        }

        if (isCutPossible(ribbons, l, k)) {
            return l;
        }

        return 0;
    }

    public boolean isCutPossible(int[] ribbons, int length, int k) {
        int count = 0;
        for (int ribbon : ribbons) {
            count += (ribbon / length);
        }
        return count >= k;
    }
}
