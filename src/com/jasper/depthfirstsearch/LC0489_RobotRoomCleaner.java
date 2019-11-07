package com.jasper.depthfirstsearch;

import java.util.HashSet;
import java.util.Set;

interface Robot {

	public boolean move();

	public void turnLeft();

	public void turnRight();

	public void clean();
}

public class LC0489_RobotRoomCleaner {

	private static final int[][] directions = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

	public void cleanRoom(Robot robot) {
		clean(robot, 0, 0, 0, new HashSet<>());
	}

	private void clean(Robot robot, int x, int y, int curDirection, Set<String> visited) {
		// Clean current cell.
		robot.clean();
		visited.add(x + " " + y);

		for (int i = 0; i < 4; i++) {
			int nx = x + directions[curDirection][0];
			int ny = y + directions[curDirection][1];
			// 在这里robot.move()已经帮忙判断的边界问题.所以我们不需要再自行判断.
			if (!visited.contains(nx + " " + ny) && robot.move()) {
				clean(robot, nx, ny, curDirection, visited);
			}
			// Change orientation.
			robot.turnRight();
			curDirection++;
			curDirection %= 4;
		}

		// Move backward one step while maintaining the orientation.
		robot.turnRight();
		robot.turnRight();
		robot.move();
		robot.turnRight();
		robot.turnRight();
	}
}
