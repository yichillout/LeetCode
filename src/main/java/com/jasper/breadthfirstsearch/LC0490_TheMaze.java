package com.jasper.breadthfirstsearch;

import java.util.*;

class Point {
	int x;
	int y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class LC0490_TheMaze {

	public static boolean hasPath(int[][] maze, int[] start, int[] destination) {

		if (maze == null || maze.length == 0 || maze[0].length == 0)
			return false;

		Queue<Point> queue = new LinkedList<Point>();

		int N = maze.length;
		int M = maze[0].length;
		int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
		boolean[][] isVisited = new boolean[N][M];

		queue.offer(new Point(start[0], start[1]));
		isVisited[start[0]][start[1]] = true;

		while (queue.size() != 0) {
			Point p = queue.poll();
			int x = p.x;
			int y = p.y;

			for (int i = 0; i < 4; i++) {

				int xx = x;
				int yy = y;

				while (xx >= 0 && yy >= 0 && xx < N && yy < M
						&& maze[xx][yy] == 0) {
					xx += dir[i][0];
					yy += dir[i][1];
				}

				xx -= dir[i][0];
				yy -= dir[i][1];

				if (xx == destination[0] && yy == destination[1]) {
					return true;
				}

				if (isVisited[xx][yy] == false) {
					queue.offer(new Point(xx, yy));
					isVisited[xx][yy] = true;
				}

			}
		}

		return false;
	}

	public static void main(String[] args) {
		int[][] maze = { { 0, 0, 1, 0, 0 }, { 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 1, 0 }, { 1, 1, 0, 1, 1 }, { 0, 0, 0, 0, 0 } };
		int[] start = { 0, 4 };
		int[] destination = { 4, 4 };
		System.out.println(hasPath(maze, start, destination));
	}

}
