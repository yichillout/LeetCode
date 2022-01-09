package com.jasper.geometry;

interface Sea {
    boolean hasShips(int[] topRight, int[] bottomLeft);
}

public class LC1274_NumberOfShipsInARectangle {

    public int countShips(Sea sea, int[] topRight, int[] bottomLeft) {
        if (!sea.hasShips(topRight, bottomLeft)) {
            return 0;
        }

        if (bottomLeft[0] == topRight[0] && bottomLeft[1] == topRight[1]) {
            return 1;
        }

        int midX = bottomLeft[0] + (topRight[0] - bottomLeft[0]) / 2;
        int midY = bottomLeft[1] + (topRight[1] - bottomLeft[1]) / 2;

        int result = 0;
        result += countShips(sea, new int[]{midX, midY}, bottomLeft);
        result += countShips(sea, new int[]{midX, topRight[1]}, new int[]{bottomLeft[0], midY + 1});
        result += countShips(sea, new int[]{topRight[0], midY}, new int[]{midX + 1, bottomLeft[1]});
        result += countShips(sea, topRight, new int[]{midX + 1, midY + 1});

        return result;
    }
}
