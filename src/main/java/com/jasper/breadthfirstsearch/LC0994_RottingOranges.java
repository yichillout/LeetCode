package com.jasper.breadthfirstsearch;

import java.util.LinkedList;
import java.util.Queue;

public class LC0994_RottingOranges {

	public int orangesRotting(int[][] grid) {

		Queue<int[]> q = new LinkedList<>();
		int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

		int level = 0;

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 2) {
					q.offer(new int[] { i, j });
				}
			}
		}

		while (!q.isEmpty()) {
			int size = q.size();

			boolean flag = false;

			for (int i = 0; i < size; i++) {
				int[] tmp = q.poll();
				int x = tmp[0];
				int y = tmp[1];

				for (int j = 0; j < 4; j++) {
					int xx = x + dir[j][0];
					int yy = y + dir[j][1];

					if (xx >= 0 && xx < grid.length && yy >= 0 && yy < grid[0].length) {
						if (grid[xx][yy] == 1) {
							q.offer(new int[] { xx, yy });
							grid[xx][yy] = 2;
							flag = true;
						}

					}
				}

			}

			if (flag) {
				level++;
			}
		}

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 1) {
					return -1;
				}
			}
		}

		return level;
	}
}
