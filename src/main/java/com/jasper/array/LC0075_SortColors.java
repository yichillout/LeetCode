package com.jasper.array;

//using counting sort
public class LC0075_SortColors {

    // solution 1 : tree way partition
    // l : the last index of 0
    // r : the first index of 1
    public void sortColors1(int[] nums) {
        int l = -1;
        int r = nums.length;
        int i = 0;

        while (i < r) {
            if (nums[i] == 0) {
                l++;
                swap(nums, l, i);
                i++;
            } else if (nums[i] == 2) {
                r--;
                swap(nums, i, r);
            } else {
                i++;
            }
        }
    }

    // solution 1 : tree way partition (different index version)
    // l : the index ready for 0
    // r : the index ready for 1
    public void sortColors2(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        int i = 0;

        while (i <= r) { // here we need to check i == r, because r is ready for 1 but not check
            if (nums[i] == 0) {
                swap(nums, l, i);
                l++;
                i++;
            } else if (nums[i] == 2) {
                swap(nums, i, r);
                r--;
            } else {
                i++;
            }
        }
    }

    public void swap(int[] nums, int x, int y) {
        int tmp = nums[x];
        nums[x] = nums[y];
        nums[y] = tmp;
    }

    // Solution 2 : Counting Sort : space is O(n)
    public static void sortColors3(int[] nums) {

        if (nums == null || nums.length == 0)
            return;

        int[] counts = new int[3];
        int[] result = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            counts[nums[i]]++;
        }

        for (int i = 1; i < 3; i++) {
            counts[i] = counts[i] + counts[i - 1];
        }

        for (int i = 0; i < nums.length; i++) {
            result[counts[nums[i]] - 1] = nums[i];
            counts[nums[i]]--;
        }

        for (int i = 0; i < nums.length; i++) {
            nums[i] = result[i];
        }

    }

    // Solution 3 : Improved Counting Sort : space is O(1)
    public static void sortColors4(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }

        int[] counts = new int[3];
        for (int i = 0; i < nums.length; i++) {
            counts[nums[i]]++;
        }

        int j = 0;
        int k = 0;
        while (j <= 2) {
            if (counts[j] != 0) {
                nums[k++] = j;
                counts[j]--;
            } else {
                j++;
            }
        }
    }
}
