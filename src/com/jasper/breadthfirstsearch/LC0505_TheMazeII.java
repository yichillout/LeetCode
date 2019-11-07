package com.jasper.breadthfirstsearch;

import java.util.*;

public class LC0505_TheMazeII {
	public int shortestDistance(int[][] maze, int[] start, int[] destination) {

		if (maze == null || maze.length == 0 || maze[0].length == 0)
			return -1;

		if (start[0] == destination[0] && start[1] == destination[1])
			return 0;

		int[][] distance = new int[maze.length][maze[0].length];
		int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

		for (int i = 0; i < distance.length; i++) {
			for (int j = 0; j < distance[0].length; j++) {
				distance[i][j] = Integer.MAX_VALUE;
			}
		}

		Queue<int[]> q = new LinkedList<>();
		q.offer(start);
		distance[start[0]][start[1]] = 0;

		while (!q.isEmpty()) {
			int[] tmp = q.poll();
			int x = tmp[0];
			int y = tmp[1];

			for (int i = 0; i < 4; i++) {
				int d = distance[x][y];
				int xx = x + dir[i][0];
				int yy = y + dir[i][1];
				while (xx >= 0 && xx < maze.length && yy >= 0 && yy < maze[0].length && maze[xx][yy] == 0) {
					d++;
					xx += dir[i][0];
					yy += dir[i][1];
				}
				xx -= dir[i][0];
				yy -= dir[i][1];

				if (distance[xx][yy] > d) {
					q.offer(new int[] { xx, yy });
					distance[xx][yy] = Math.min(distance[xx][yy], d);
				}
			}

		}

		if (distance[destination[0]][destination[1]] == Integer.MAX_VALUE)
			return -1;

		return distance[destination[0]][destination[1]];
	}
}