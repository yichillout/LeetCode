package com.jasper.hashtable;

import java.util.HashMap;

public class LC0149_MaxPointsOnALine {
	public int maxPoints(Point[] points) {
		if (points.length == 0 || points == null)
			return 0;

		if (points.length == 1)
			return 1;

		int max = 1; // the final max value, at least one
		for (int i = 0; i < points.length; i++) {
			HashMap<Float, Integer> hm = new HashMap<Float, Integer>();
			int same = 0;
			int localmax = 1; // the max value of current slope, at least one
			for (int j = 0; j < points.length; j++) {
				if (i == j)
					continue;

				if (points[i].x == points[j].x && points[i].y == points[j].y) {
					same++;
					continue;
				}

				float slope = ((float) (points[i].y - points[j].y))
						/ (points[i].x - points[j].x);

				if (hm.containsKey(slope))
					hm.put(slope, hm.get(slope) + 1);
				else
					hm.put(slope, 2); // two points form a line
			}

			for (Integer value : hm.values())
				localmax = Math.max(localmax, value);

			localmax += same;
			max = Math.max(max, localmax);
		}
		return max;
	}

}
