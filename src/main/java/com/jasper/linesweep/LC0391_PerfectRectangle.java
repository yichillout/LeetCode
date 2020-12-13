package com.jasper.linesweep;

import java.util.*;

class Point {

    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return x == point.x &&
                y == point.y;
    }

    public int hashCode() {
        return Objects.hash(x, y);
    }
}

class LC0391_PerfectRectangle {

    public boolean isRectangleCover(int[][] rectangles) {

        Set<Point> hs = new HashSet<>();
        int area = 0;

        for (int i = 0; i < rectangles.length; i++) {
            Point lb = new Point(rectangles[i][0], rectangles[i][1]);
            Point lt = new Point(rectangles[i][0], rectangles[i][3]);
            Point rb = new Point(rectangles[i][2], rectangles[i][1]);
            Point rt = new Point(rectangles[i][2], rectangles[i][3]);

            List<Point> pList = new ArrayList<>();
            pList.add(lb);
            pList.add(lt);
            pList.add(rb);
            pList.add(rt);

            for (int j = 0; j < pList.size(); j++) {
                Point p = pList.get(j);
                if (hs.contains(p)) {
                    hs.remove(p);
                } else {
                    hs.add(p);
                }
            }

            area += (rt.y - lb.y) * (rt.x - lb.x);
        }

        if (hs.size() != 4) {
            return false;
        }

        int et = Integer.MIN_VALUE;
        int eb = Integer.MAX_VALUE;
        int el = Integer.MAX_VALUE;
        int er = Integer.MIN_VALUE;

        Iterator<Point> it = hs.iterator();

        while (it.hasNext()) {
            Point tmp = it.next();
            et = Math.max(tmp.y, et);
            eb = Math.min(tmp.y, eb);
            er = Math.max(tmp.x, er);
            el = Math.min(tmp.x, el);
        }

        return area == (et - eb) * (er - el);
    }
}
