package com.jasper.design;

import java.util.*;

class Vector2D {

    int[][] data;
    int row;
    int col;

    public Vector2D(int[][] vec) {
        data = vec;
        row = 0;
        col = 0;
    }

    public int next() {
        if (hasNext()) {
            return data[row][col++];
        }
        return -1;
    }

    public boolean hasNext() {
        while (row < data.length && col == data[row].length) {
            row++;
            col = 0;
        }
        return row < data.length;
    }
}

public class LC0251_Flatten2DVector {

}
