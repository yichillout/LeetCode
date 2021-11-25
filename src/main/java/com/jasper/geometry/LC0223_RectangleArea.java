package com.jasper.geometry;

public class LC0223_RectangleArea {

    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int area1 = (ax2 - ax1) * (ay2 - ay1);
        int area2 = (bx2 - bx1) * (by2 - by1);

        if (!isOverLap(ax1, ay1, ax2, ay2, bx1, by1, bx2, by2)) {
            return area1 + area2;
        } else {
            int minX = Math.max(ax1, bx1);
            int minY = Math.max(ay1, by1);
            int maxX = Math.min(ax2, bx2);
            int maxY = Math.min(ay2, by2);
            return area1 + area2 - (maxX - minX) * (maxY - minY);
        }
    }

    public boolean isOverLap(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        return ax1 < bx2 && bx1 < ax2 && ay1 < by2 && by1 < ay2;
    }
}
