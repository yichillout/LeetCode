package com.jasper.geometry;

public class LC0836_RectangleOverlap {

    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        return isLess(rec1[0], rec1[1], rec2[2], rec2[3]) && isLess(rec2[0], rec2[1], rec1[2], rec1[3]);
    }

    public boolean isLess(int x1, int y1, int x2, int y2) {
        return x1 < x2 && y1 < y2;
    }
}
