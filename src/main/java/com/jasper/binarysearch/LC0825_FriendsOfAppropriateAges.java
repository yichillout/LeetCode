package com.jasper.binarysearch;

import java.util.Arrays;

// TODO
public class LC0825_FriendsOfAppropriateAges {

    public int numFriendRequests(int[] ages) {
        int result = 0;
        Arrays.sort(ages);
        for (int i = 0; i < ages.length; ++i) {
            int age = ages[i];
            int lower = firstIdx(ages, age / 2 + 7);
            int upper = firstIdx(ages, age);
            // (0.5 * A + 7, A]
            result += Math.max(upper - lower - 1, 0);
        }
        return result;
    }

    private static int firstIdx(int[] ages, int target) {
        int l = 0;
        int r = ages.length - 1;

        while (l + 1 < r) {
            int mid = l + (r - l) / 2;
            if (ages[mid] <= target) {
                l = mid;
            } else {
                r = mid;
            }
        }

        if(ages[l] <= target) {
            return l;
        }

        return r;
    }
}
