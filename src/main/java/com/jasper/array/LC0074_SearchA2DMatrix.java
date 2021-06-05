package com.jasper.array;

public class LC0074_SearchA2DMatrix {

	public static boolean searchMatrix(int[][] matrix, int target) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
			return false;

		int r = matrix.length;
		int c = matrix[0].length;

		if (target < matrix[0][0] || target > matrix[r - 1][c - 1])
			return false;

		int rr = 0;
		int cc = matrix[0].length - 1;
		while (rr <= (r - 1) && cc >= 0) {
			if (matrix[rr][cc] == target) {
				return true;
			} else if (matrix[rr][cc] < target) {
				rr++;
			} else {
				cc--;
			}
		}

		return false;
	}

	public static void main(String[] args) {
		int[][] matrix = { { 1, 3 } };
		System.out.println(searchMatrix(matrix, 2));
	}
}
