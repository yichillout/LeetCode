package com.jasper.binarysearch;

public class BinarySearchTemplate {

	public static int[] searchRange(int[] nums, int target) {

		int[] result = new int[2];
		int lo = 0;
		int hi = nums.length - 1;

		int l = 0;
		int r = nums.length;

		while (l + 1 < r) {
			int mid = l + (r - l) / 2;
			if (nums[mid] >= target) {
				r = mid;
			} else {
				l = mid;
			}
		}

		result[0] = l;
		result[1] = r;

		return result;
	}

	public static int[] searchRange1(int[] nums) {
		int[] result = new int[2];
		int lo = 0;
		int hi = nums.length - 1;

		int l = 0;
		int r = nums.length;

		while (l + 1 < r) {
			int mid = l + (r - l) / 2;
			if (nums[mid] > nums[mid + 1]) {
				r = mid;
			} else {
				l = mid;
			}
		}
		result[0] = l;
		result[1] = r;
		return result;
	}

	public static void main(String[] args) {

		int[] nums1 = new int[] { 4, 6, 10, 10, 11, 11, 11, 11, 11, 12 };

		for (Integer num : nums1) {
			System.out.print(num + " ");
		}

		System.out.println("\n");

		int[] res1 = searchRange(nums1, 1);
		System.out.println(1 + "   :  " + res1[0] + " : " + res1[1]);

		int[] res2 = searchRange(nums1, 13);
		System.out.println(13 + "  :  " + res2[0] + " : " + res2[1]);

		int[] res3 = searchRange(nums1, 10);
		System.out.println(10 + "  :  " + res3[0] + " : " + res3[1]);

		int[] res4 = searchRange(nums1, 6);
		System.out.println(6 + "   :  " + res4[0] + " : " + res4[1]);

		int[] res5 = searchRange(nums1, 4);
		System.out.println(4 + "   :  " + res5[0] + " : " + res5[1]);

		int[] res6 = searchRange(nums1, 11);
		System.out.println(11 + "  :  " + res6[0] + " : " + res6[1]);

		int[] res7 = searchRange(nums1, 7);
		System.out.println(7 + "   :  " + res7[0] + " : " + res7[1]);

		int[] res8 = searchRange(nums1, 8);
		System.out.println(8 + "   :  " + res8[0] + " : " + res8[1]);

		int[] res9 = searchRange(nums1, 9);
		System.out.println(9 + "   :  " + res9[0] + " : " + res9[1]);

		System.out.println("\n");

		int[] nums2 = new int[] { 1, 2, 1, 3, 4, 5, 7, 6 };

		for (Integer num : nums2) {
			System.out.print(num + " ");
		}

		System.out.println("\n");

		int[] res10 = searchRange1(nums2);
		System.out.println(res10[0] + " : " + res10[1]);
	}

}
