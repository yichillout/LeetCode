package com.jasper.greedy;

public class LC0605_CanPlaceFlowers {

    // solution 1
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 0 && (i == 0 || flowerbed[i - 1] == 0) && (i == flowerbed.length - 1 || flowerbed[i + 1] == 0)) {
                flowerbed[i] = 1;
                count++;

            }

            if (count >= n) {
                return true;
            }
        }

        return false;
    }

    // solution 2
    public boolean canPlaceFlowers1(int[] flowerbed, int n) {
        int count = 0;
        int count1 = 0;

        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 1) {
                count1 = 2;
            } else {
                count1--;
                if (count1 <= 0 && (i == flowerbed.length - 1 || flowerbed[i + 1] == 0)) {
                    count++;
                    count1 = 2;
                }
            }
        }

        return count >= n;
    }
}
