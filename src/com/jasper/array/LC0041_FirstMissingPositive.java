package com.jasper.array;

/*
 * 	test case :            3,4,-1,1
 *  finally it will become 1,4,3,-1
 *  at the position of -1, it should be 2
 *  A[i] != (i + 1)
 *
 * */

public class LC0041_FirstMissingPositive {
	public static int firstMissingPositive(int[] A) {
		int i = 0;
		while (i < A.length) {
			if (A[i] != (i + 1) && A[i] >= 1 && A[i] <= A.length && A[A[i] - 1] != A[i]) {
				int temp = A[i];
				A[i] = A[temp - 1];
				A[temp - 1] = temp;  // example: put 3 to A[2]; put 4 to A[3]
			} else
				i++;
		}
		for (i = 0; i < A.length; ++i)
			if (A[i] != (i + 1))
				return i + 1;
		return A.length + 1;
	}
	
	public static void main(String[] args){
		int[] nums = {3,4,-1,1};
		System.out.println(firstMissingPositive(nums));
	}
}
