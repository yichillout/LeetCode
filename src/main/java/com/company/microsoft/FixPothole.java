package com.company.microsoft;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FixPothole {
    public static void main(String[] args) {
        String input1 = "...xxx...xxx...x";
        String input2 = "...xxxxxxx...xxxx.xxxx";
        String input3 = "x.x.xxx...x";
        String input4 = "...";

        int result = getMaxCount(input1, 7);
        System.out.println("result1 ==" + result);

        int result2 = getMaxCount(input2, 11);
        System.out.println("result2 ==" + result2);

        int result3 = getMaxCount(input3, 14);
        System.out.println("result3 ==" + result3);

        int result4 = getMaxCount(input4, 5);
        System.out.println("result4 ==" + result4);
    }

    private static int getMaxCount(String input, int budget) {
        List<Integer> consecutiveBlocks = new ArrayList<>();
        int consecutiveCount = 0;
        int index = 0;
        for (char i : input.toCharArray()) {
            if (i == '.' && consecutiveCount != 0) {
                consecutiveBlocks.add(consecutiveCount);
                consecutiveCount = 0;
            }

            if (i == 'x') {
                consecutiveCount++;
            }
        }

        if (consecutiveCount != 0) {
            consecutiveBlocks.add(consecutiveCount);
        }

        Collections.sort(consecutiveBlocks, Collections.reverseOrder());

        int result = 0;
        for (int blockSize : consecutiveBlocks) {
            if (budget < blockSize + 1) {
                result += budget - 1;
                break;
            }
            result += blockSize;
            budget -= (blockSize + 1);
        }
        return result;
    }
}

