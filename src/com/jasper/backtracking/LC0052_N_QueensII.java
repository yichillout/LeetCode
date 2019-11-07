package com.jasper.backtracking;

public class LC0052_N_QueensII {

	int count = 0;

	public int totalNQueens(int n) {
		int[] x = new int[n];
		queens(x, n, 0);
		return count;
	}

	void queens(int[] x, int n, int row) {
		for (int i = 0; i < n; i++) {
			if (check(x, n, row, i)) {// 判断合法
				x[row] = i;// 将皇后放在第row行，第i列
				if (row == n - 1) {// 如果是最后一行，则输出结果
					count++;
					x[row] = 0;// 回溯，寻找下一个结果
					return;
				}
				queens(x, n, row + 1);// 寻找下一行
				x[row] = 0;// 回溯
			}
		}
	}

	/**
	 * @param x      数组解
	 * @param n      棋盘长宽
	 * @param index  当前放置行
	 * @param i      当前放置列
	 * @return
	 */
	boolean check(int[] x, int n, int row, int col) {
		for (int i = 0; i < row; i++) {
			if (x[i] == col || x[i] + i == col + row || x[i] - i == col - row)
				return false;
		}
		return true;
	}

	public static void main(String[] args) {

	}

}
