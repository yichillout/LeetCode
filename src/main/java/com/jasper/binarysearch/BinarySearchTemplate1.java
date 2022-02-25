package com.jasper.binarysearch;

public class BinarySearchTemplate1 {

    public static int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];

        int l = 0;
        int r = nums.length - 1;

        while (l + 1 < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] > nums[l]) {
                if (target >= nums[l] && target <= nums[mid]) {
                    l = mid;
                } else {
                    r = mid;
                }
            } else {
                if (target >= nums[mid] && target <= nums[r]) {
                    l = mid;
                } else {
                    r = mid;
                }
            }
        }

        result[0] = l;
        result[1] = r;

        return result;
    }

    public static void main(String[] args) {

        int[] nums1 = new int[]{4, 5, 6, 7, 0, 1, 2};

        for (int i = 0; i < nums1.length; i++) {
            System.out.print(" " + i);
        }

        System.out.println("");

        for (int i = 0; i < nums1.length; i++) {
            System.out.print(" " + nums1[i]);
        }

        System.out.println("\n");

        int[] res1 = searchRange(nums1, 1);
        System.out.println(1 + "   :  " + res1[0] + " : " + res1[1]);

        int[] res2 = searchRange(nums1, 2);
        System.out.println(13 + "  :  " + res2[0] + " : " + res2[1]);

        int[] res3 = searchRange(nums1, 3);
        System.out.println(10 + "  :  " + res3[0] + " : " + res3[1]);

        int[] res4 = searchRange(nums1, 4);
        System.out.println(6 + "   :  " + res4[0] + " : " + res4[1]);

        int[] res5 = searchRange(nums1, 5);
        System.out.println(4 + "   :  " + res5[0] + " : " + res5[1]);

        int[] res6 = searchRange(nums1, 9);
        System.out.println(11 + "  :  " + res6[0] + " : " + res6[1]);
    }

}
