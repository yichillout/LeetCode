package com.jasper.breadthfirstsearch;

import java.util.LinkedList;
import java.util.Queue;

public class LC0934_ShortestBridge {

	public int shortestBridge(int[][] A) {

		Queue<int[]> q = new LinkedList<>();
		int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

		boolean found = false;

		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < A[0].length; j++) {
				if (A[i][j] == 1) {
					dfs(A, i, j, dir, q);
					found = true;
					break;
				}
			}
			if (found) {
				break;
			}
		}

		int level = 0;

		while (!q.isEmpty()) {

			int size = q.size();
			level++;

			for (int i = 0; i < size; i++) {
				int[] tmp = q.poll();
				int x = tmp[0];
				int y = tmp[1];

				for (int j = 0; j < 4; j++) {
					int xx = x + dir[j][0];
					int yy = y + dir[j][1];

					if (xx >= 0 && xx < A.length && yy >= 0 && yy < A[0].length) {
						if (A[xx][yy] == 1) {
							return level - 1;
						}
						if (A[xx][yy] == 0) {
							q.offer(new int[] { xx, yy });
							A[xx][yy] = 2;
						}
					}
				}
			}
		}

		return -1;
	}

	private void dfs(int[][] A, int x, int y, int[][] dir, Queue<int[]> q) {
		if (x < 0 || x >= A.length || y < 0 || y >= A[0].length || A[x][y] == 0 || A[x][y] == 2)
			return;

		q.offer(new int[] { x, y });
		A[x][y] = 2;

		for (int i = 0; i < 4; i++) {
			dfs(A, x + dir[i][0], y + dir[i][1], dir, q);
		}
	}
}
