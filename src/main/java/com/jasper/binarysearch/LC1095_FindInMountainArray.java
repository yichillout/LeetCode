package com.jasper.binarysearch;

interface MountainArray {

    int get(int index);

    int length();
}

public class LC1095_FindInMountainArray {

    public int findInMountainArray(int target, MountainArray mountainArr) {

        int l = 0;
        int r = mountainArr.length() - 1;

        while (l + 1 < r) {
            int mid = l + (r - l) / 2;
            if (mountainArr.get(mid) < mountainArr.get(mid + 1)) {
                l = mid;
            } else {
                r = mid;
            }
        }

        int peak = mountainArr.get(l) > mountainArr.get(r) ? l : r;

        l = 0;
        r = peak;

        while (l + 1 < r) {
            int mid = l + (r - l) / 2;
            if (target > mountainArr.get(mid)) {
                l = mid;
            } else {
                r = mid;
            }
        }

        if (mountainArr.get(l) == target) {
            return l;
        }

        if (mountainArr.get(r) == target) {
            return r;
        }

        l = peak;
        r = mountainArr.length() - 1;

        while (l + 1 < r) {
            int mid = l + (r - l) / 2;
            if (target > mountainArr.get(mid)) {
                r = mid;
            } else {
                l = mid;
            }
        }

        if (mountainArr.get(l) == target) {
            return l;
        }

        if (mountainArr.get(r) == target) {
            return r;
        }

        return -1;
    }
}
