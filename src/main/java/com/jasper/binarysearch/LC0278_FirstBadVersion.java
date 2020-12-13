package com.jasper.binarysearch;

public class LC0278_FirstBadVersion {

	public static boolean[] version;

	public static int firstBadVersion(int n) {
		int start = 1, end = n;
		while (start < end) {
			int mid = start + (end - start) / 2;
			if (isBadVersion(mid))
				end = mid;
			else
				start = mid + 1;
		}
		return start;
	}

	public static boolean isBadVersion(int n) {
		return !version[n];
	}

	public static void main(String[] args) {
		int n = 10;
		version = new boolean[n + 1];
		System.out.println(firstBadVersion(n));
	}
}
